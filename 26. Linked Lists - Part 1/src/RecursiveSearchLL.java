// Recursive Search in a Linked List:

public class RecursiveSearchLL {

    // Node Class
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
    public void printLinkedList() {
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

    // Recursive Helper Function
    public int helper(Node head, int key) {

        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    // Recursive Search Function
    public int recursiveSearch(int key) {
        return helper(head, key);
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

    // Add Middle
    public void addMiddle(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1 && temp != null) {
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

    // Main Function
    public static void main(String[] args) {

        RecursiveSearchLL list = new RecursiveSearchLL();

        list.printLinkedList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.addLast(4);
        list.addLast(5);

        list.addMiddle(3, 9);

        System.out.println("\nLinked List:");
        list.printLinkedList();

        System.out.println("\nRecursive Search for 9:");
        System.out.println("Index = " + list.recursiveSearch(9));

        System.out.println("\nRemove First:");
        list.removeFirst();
        list.printLinkedList();

        System.out.println("\nRemove Last:");
        list.removeLast();
        list.printLinkedList();

        System.out.println("\nSize of Linked List: " + size);
    }
}
