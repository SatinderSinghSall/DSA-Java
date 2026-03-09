// File Name: RemoveNthNodeFromEnd.java

public class RemoveNthNodeFromEnd {

    // Node class for Linked List
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of Linked List
    public static Node head;

    // Function to print Linked List
    public void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Function to add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Function to remove Nth node from end
    public void deleteNthFromEnd(int n) {

        // Step 1: Calculate size of Linked List
        int size = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Step 2: If first node needs to be removed
        if (n == size) {
            head = head.next;
            return;
        }

        // Step 3: Find previous node of node to delete
        int i = 1;
        int indexToFind = size - n;
        Node prev = head;

        while (i < indexToFind) {
            prev = prev.next;
            i++;
        }

        // Step 4: Remove node
        prev.next = prev.next.next;
    }

    // Main method
    public static void main(String[] args) {

        RemoveNthNodeFromEnd list = new RemoveNthNodeFromEnd();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original Linked List:");
        list.printLL();

        list.deleteNthFromEnd(2);

        System.out.println("After Removing 2nd Node From End:");
        list.printLL();
    }
}
