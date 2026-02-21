// Linked List Data Structure:

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head & Tail of a Linked List:
    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        // Step 1 - Create a new Node:
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2 - newNode next = head
        newNode.next = head; // linked

        // Step 3 - head = newNode
        head = newNode;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
    }
}
