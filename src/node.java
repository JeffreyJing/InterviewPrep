public class node {
    node next;
    private int value;

    public node(int value, node next) {
        this.next = next;
        this.value = value;
    }

    public node() {
        this(0, null);
    }

    public node(int value) {
        this(value, null);
    }


    public int getValue() {
        return this.value;
    }

    public int compareTo(node other) {
        return this.value - other.value;
    }
}
