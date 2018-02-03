public class node<T extends Comparable<T>> implements  Comparable<node<T>> {
    node next;
    node back;
    private T value;

    public node(node<T> next, node<T> back, T value) {
        this.next = next;
        this.back = back;
        this.value = value;
    }

    public node() {
        this(null, null, null);
    }

    public node(T value) {
        this(null, null, value);
    }

    public int compareTo(node<T> other) {
        return 1;
    }
}
