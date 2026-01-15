package h2;

public class H2_main {

    // Globales Cache-Array für fibonacciCached
    private static long[] cache = new long[1000];

    public static void main(String[] args) {
        benchmark(40); // n kann hier beliebig angepasst werden
    }

    /**
     * Führt nacheinander alle drei Fibonacci-Methoden aus
     * und misst jeweils die Ausführungszeit.
     */
    public static void benchmark(int n) {

        long start, end, result;

        // (a) Rekursiv ohne Cache
        start = System.nanoTime();
        result = fibonacci(n);
        end = System.nanoTime();
        System.out.println("Fibonacci (rekursiv): " + result);
        System.out.println("Elapsed nanoseconds (fibonacci): " + (end - start));
        System.out.println();

        // Cache zurücksetzen
        cache = new long[1000];

        // (b) Rekursiv mit Cache
        start = System.nanoTime();
        result = fibonacciCached(n);
        end = System.nanoTime();
        System.out.println("Fibonacci (rekursiv, cached): " + result);
        System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end - start));
        System.out.println();

        // (c) Iterativ
        start = System.nanoTime();
        result = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Fibonacci (iterativ): " + result);
        System.out.println("Elapsed nanoseconds (fibonacciIterative): " + (end - start));
    }

    /**
     * (a) Rekursive Fibonacci-Berechnung
     */
    public static long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * (b) Rekursive Fibonacci-Berechnung mit Caching (Memoization)
     */
    public static long fibonacciCached(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        return cache[n];
    }

    /**
     * (c) Iterative Fibonacci-Berechnung
     */
    public static long fibonacciIterative(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        long prev1 = 1;
        long prev2 = 1;
        long current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }
}
