import java.util.*;
public class LinkedList {

    private node head;
    private int length;

    // This is a default LinkedList constructor
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    // This is a constructor that creates a LinkedList of length 1 with the given
    // integer parameter.
    public LinkedList(int value) {
        this.head = new node(value);
        this.length = 1;
    }

    // This is a copy constructor that creates a copy of the given LinkedList parameter.
    public LinkedList(LinkedList otherList) {
        if (otherList != null) {
            node temp = otherList.head;
            this.insert(temp.getValue(), 0);
            temp = temp.next;
            int index = 1;
            while (temp != null) {
                this.insert(temp.getValue(), index);
                temp = temp.next;
                index++;
            }
        } else {
            this.head = null;
        }
    }

    // Prints out this LinkedList in "1 2 3 4 5" format.
    public void print() {
        node temp = this.head;
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.next;
        }
    }

    // Returns the head of this LinkedList.
    public node getHead() {
        return this.head;
    }

    // Pre : The given index parameter must be a valid index (greater than 0 and less than
    // the current length of this LinkedList) (returns false otherwise).
    //
    // Post: Inserts a new node with the given value parameter as its value at the given parameter index.
    public boolean insert(int value, int index) {
        if (index == 0) {
            this.head = new node(value, head);
            this.length++;
            return true;
        }

        if (index <= this.length && index >= 0) {
            node temp = this.head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            temp.next = new node(value, temp.next);
            this.length++;
            return true;
        }

        return false;
    }

    // Inserts a new node with the given value parameter as its value at the front of this LinkedList.
    public boolean insert(int value) {
        return this.insert(value, 0);
    }

    // Returns the length of this LinkedList.
    public int getLength() {
        return this.length;
    }


    // Returns whether the given parameter LinkedList is equal to this LinkedList
    // (equal meaning containing the same value elements and being the same length).
    public boolean equals(LinkedList otherList) {
        if (otherList.getLength() != this.getLength()) {
            return false;
        }

        node thisCurrent = this.head;
        node otherCurrent = otherList.head;
        while (thisCurrent != null && otherCurrent != null) {
            if (thisCurrent.getValue() != otherCurrent.getValue()) {
                return false;
            }

            thisCurrent = thisCurrent.next;
            otherCurrent = otherCurrent.next;
        }

        return true;
    }


}
