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
    public static int size;

    // Printing a Linked List:
    public void PrintLinkedList() {
        if(head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " " + "--> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // Add first in Linked List.
    public void addFirst(int data) {
        // Step 1 - Create a new Node:
        Node newNode = new Node(data);
        size ++;

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
        size ++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2 - tail.Next - newNode:
        tail.next = newNode;

        // Step 3 - tail = newNode:
        tail = newNode;
    }

    // Add in the Middle of Linked List:
    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size ++;

        Node temp = head;
        int i = 0;

        while (temp != null && i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // invalid index
        if (temp == null) {
            System.out.println("Invalid index!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        // update tail if inserted at last
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("\nLinklist is Empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size ++;
            return val;
        }

        int val = head.data;
        head = head.next;
        size --;
        return val;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.PrintLinkedList();
        linkedList.addFirst(2);

        linkedList.PrintLinkedList();
        linkedList.addFirst(1);

        linkedList.PrintLinkedList();
        linkedList.addLast(5);

        linkedList.PrintLinkedList();
        linkedList.addLast(5);

        linkedList.addMiddle(2, 3);

        System.out.println();
        linkedList.PrintLinkedList();

        System.out.println();
        linkedList.removeFirst();
        linkedList.PrintLinkedList();

        System.out.println("\nSize of Linked List: " + linkedList.size);
    }
}
