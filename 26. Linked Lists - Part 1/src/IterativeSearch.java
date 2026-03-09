// Iterative Search in a Linked List:

public class IterativeSearch {

    // Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head, Tail and Size
    public static Node head;
    public static Node tail;
    public static int size;

    // Print Linked List
    public void PrintLinkedList() {
        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // Iterative Search
    public int search(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i; // key found
            }
            temp = temp.next;
            i++;
        }

        return -1; // key not found
    }

    // Add First
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Add in Middle
    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (temp != null && i < idx - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Invalid index!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // Remove First
    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;

        return val;
    }

    // Remove Last
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    // Main Method
    public static void main(String[] args) {

        IterativeSearch linkedList = new IterativeSearch();

        linkedList.PrintLinkedList();

        linkedList.addFirst(2);
        linkedList.PrintLinkedList();

        linkedList.addFirst(1);
        linkedList.PrintLinkedList();

        linkedList.addLast(5);
        linkedList.PrintLinkedList();

        linkedList.addLast(6);
        linkedList.PrintLinkedList();

        linkedList.addMiddle(2, 3);

        System.out.println();
        linkedList.PrintLinkedList();

        System.out.println("\nSearch index of 3: " + linkedList.search(3));

        System.out.println("\nRemove First:");
        linkedList.removeFirst();
        linkedList.PrintLinkedList();

        System.out.println("\nRemove Last:");
        linkedList.removeLast();
        linkedList.PrintLinkedList();

        System.out.println("\nSize of Linked List: " + linkedList.size);
    }
}
