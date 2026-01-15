package h3;

import java.util.Arrays;

public class H3_main {

    public static void main(String[] args) {

        int[] array = {7, 2, 9, 4, 3, 8, 1, 6, 5};

        int[] sorted = mergeSort(array);

        System.out.println("Original: " + Arrays.toString(array));
        System.out.println("Sortiert: " + Arrays.toString(sorted));
    }

    /**
     * Rekursive Merge-Sort-Methode
     * @param arr Eingabearray
     * @return sortiertes Array
     */
    public static int[] mergeSort(int[] arr) {

        // Base Case: Array der Länge 0 oder 1 ist bereits sortiert
        if (arr.length <= 1) {
            return arr;
        }

        // Array teilen
        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Rekursiv sortieren
        left = mergeSort(left);
        right = mergeSort(right);

        // Zusammenführen
        return merge(left, right);
    }

    /**
     * Führt zwei sortierte Arrays zu einem sortierten Array zusammen
     */
    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Solange beide Arrays Elemente haben
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Restliche Elemente kopieren
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
