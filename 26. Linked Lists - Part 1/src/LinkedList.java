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

    // Add first in Linked List.
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

    // Add Last in Linked List:
    public void addLast(int data) {
        // Step 1 - Create a new Node:
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2 - tail.Next - newNode:
        tail.next = newNode;

        // Step 3 - tail = newNode:
        tail = newNode;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        linkedList.addLast(4);
    }
}
