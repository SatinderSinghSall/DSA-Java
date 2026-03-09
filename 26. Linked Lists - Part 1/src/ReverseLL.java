// Reverse a Linked List:

public class ReverseLL {

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

    // Reverse Linked List
    public void reverse() {

        Node prev = null;
        Node curr = head;
        Node next;

        tail = head;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Main Function
    public static void main(String[] args) {

        ReverseLL list = new ReverseLL();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original Linked List:");
        list.printLinkedList();

        list.reverse();

        System.out.println("\nReversed Linked List:");
        list.printLinkedList();
    }
}
