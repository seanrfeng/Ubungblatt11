package h1;

public class Node {

    private Node next;

    // Konstruktor
    public Node(Node next) {
        this.next = next;
    }

    // Getter
    public Node getNext() {
        return next;
    }

    // Setter
    public void setNext(Node next) {
        this.next = next;
    }
}
