import java.util.*;
public class tests {
    public static void main(String[] args) {
        // test empty constructor
        LinkedList list1 = new LinkedList();
        System.out.print("list1 is: ");
        list1.print();
        System.out.println();

        // test default constructor (length 1)
        LinkedList list2 = new LinkedList(5);
        System.out.print("list2 is: ");
        list2.print();
        System.out.println();

        // test array constructor
        int[] array = new int[13];
        for (int i = 0; i < 13; i++) {
            array[i] = i * 2;
        }

        LinkedList longLinkedList = new LinkedList(array);
        System.out.print("longLinkedList is: ");
        longLinkedList.print();
        System.out.println();
        System.out.println();

        // test basic insert()
        insertIntoList(6, list2, "list2");
        insertIntoList(7, list2, "list2");
        insertIntoList(8, list2, "list2");
        insertIntoList(100, list1, "list1");
        System.out.println();

        // test insert() at given indices
        insertAtIndex(5, 1, list1, "list1");
        insertAtIndex(10, 0, list1, "list1");
        insertAtIndex(20, 0, list1, "list1");
        insertAtIndex(15, 1, list1, "list1");
        insertAtIndex(40, 2, list1, "list1");
        insertAtIndex(50, -1, list1, "list1");
        insertAtIndex(101, 10, list1, "list1");
        System.out.println();

        // test copy constructor
        LinkedList list3 = new LinkedList(list2);
        testCopyConstructor(list2, list3, "list2", "list3");
        testCopyConstructor(new LinkedList(), new LinkedList(new LinkedList()), "emptyList", "otherEmptyList");
        testCopyConstructor(new LinkedList(5), new LinkedList(new LinkedList(5)), "original", "copy");
        System.out.println();

        // test makeEmpty()
        System.out.println("Testing makeEmpty().");
        testMakeEmpty(list3, "list3");
        LinkedList list4 = new LinkedList();
        testMakeEmpty(list4, "list4");
        System.out.println();

        // test remove()
        System.out.println("Testing remove().");
        testRemove(list3, 5, "list3");
        testRemove(list3, 6, "list3");
        testRemove(list2, 5, "list2");
        testRemove(list2, 6, "list2");
        System.out.println();

        // test contains()
        System.out.println("Testing contains().");
        testContains(list3, 5, "list3");
        testContains(list2, 5, "list2");
        testContains(list2, 7, "list2");
        testContains(list2, 8, "list2");
        System.out.println();

        // test elementAtIndex()
        System.out.println("Testing elementAtIndex().");
        testElementAtIndex(longLinkedList, 3, "longLinkedList");
        testElementAtIndex(longLinkedList, -1, "longLinkedList");
        testElementAtIndex(longLinkedList, 0, "longLinkedList");
        testElementAtIndex(longLinkedList, 14, "longLinkedList");
    }

    // Inserts a given 'num' value into the given 'list' LinkedList and prints a statement
    // on the modifications of the given 'list' LinkedList.
    public static void insertIntoList(int num, LinkedList list, String listName) {
        System.out.println("Inserting " + num + " into " + listName + ". ");
        System.out.print(listName + " is now: ");
        list.insert(num);
        list.print();
        System.out.println(", and its length is: " + list.getLength());
    }

    // Attempts to insert a given value into the given 'list' LinkedList at the given index,
    // and prints a message based on whether the insert was successful.
    public static void insertAtIndex(int value, int index, LinkedList list, String listName) {
        System.out.println("Now attempting to insert " + value + " at index " + index + " into " + listName + ".");
        if (list.insert(value, index)) {
            System.out.print(listName + " is now: ");
            list.print();
            System.out.println(", and its length is: " + list.getLength());
        } else {
            System.out.println("Insert attempt failed: ivalid index value.");
            System.out.println("The length of " + listName + " is currently " + list.getLength() + ".");
        }
    }

    // Prints a message about the status of an attempted LinkedList copy.
    // Success is determined by whether each of first's nodes' values are equal to each of second's, while
    // first and second are separate LinkedLists.
    public static void testCopyConstructor(LinkedList first, LinkedList second, String firstName, String secondName) {
        System.out.println("Now attempting to make a copy of " + firstName + " and store it in " + secondName + ".");
        System.out.print(firstName + " = ");
        first.print();
        System.out.println();
        System.out.print(secondName + " = ");
        second.print();
        System.out.println();
        if (first.equals(second) && uniqueNodes(first.getHead(), second.getHead())) {
            System.out.println("Success! A copy of " + firstName + " has been stored in " + secondName + ".");
        } else {
            System.out.println("Error: " + first + " was not successfully copied.");
        }
    }

    // Returns true if first and each of first's next nodes are not pointing to the same
    // nodes second and second's next nodes are pointing to.
    public static boolean uniqueNodes(node first, node second) {
        while (first != null && second != null) {
            return first != second && uniqueNodes(first.next, second.next);
        }

        return true;
    }

    // Tests the LinkedList's makeEmpty() method and prints out a message
    // based on the results.
    public static void testMakeEmpty(LinkedList list, String listName) {
        System.out.print(listName + " before makeEmpty(): ");
        list.print();
        System.out.println();
        list.makeEmpty();
        System.out.print(listName + "  after makeEmpty(): ");
        list.print();
        if (list.isEmpty()) {
            System.out.println();
            System.out.println("Success! " + listName + " is now empty.");
        } else {
            System.out.println("Error: makeEmpty() failed.");
        }
    }

    // Tests the LinkedList's remove() method and prints out a message
    // based on the results.
    public static void testRemove(LinkedList list, int value, String listName) {
        System.out.print(listName + " before remove(): ");
        list.print();
        System.out.println();
        if (list.remove(value)) {
            System.out.println("Successfully removed " + value + " from " + listName);
        } else {
            System.out.println("Error: remove() failed. " + value + " is not found in " + listName + ".");
        }

        System.out.print(listName + "  after remove(): ");
        list.print();
        System.out.println();
    }

    // Tests the LinkedList's contains method.
    public static void testContains(LinkedList list, int value, String listName) {
        System.out.print(listName + " = ");
        list.print();
        System.out.print(", value = " + value + ".");
        System.out.println();
        System.out.println(listName + " contains " + value + ": " + list.contains(value));
    }

    // Tests the LinkedList's elementAtIndex
    public static void testElementAtIndex(LinkedList list, int index, String listName) {
        System.out.print(listName + " = ");
        list.print();
        System.out.println();
        System.out.println("The element at index " + index + " is " + list.elementAtIndex(index) + ".");
    }
}