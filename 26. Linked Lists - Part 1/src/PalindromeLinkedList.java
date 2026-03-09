// File Name: PalindromeLinkedList.java

public class PalindromeLinkedList {

    // Node class
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

    // Print Linked List
    public void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Add node at end
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

    // Find middle of Linked List
    public Node findMid(Node head) {

        Node slow = head;
        Node fast = head;

        // Fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Check if Linked List is Palindrome
    public boolean checkPalindrome() {

        // Empty or single node list is palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle
        Node midNode = findMid(head);

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Compare both halves
        Node left = head;
        Node right = prev;

        while (right != null) {

            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        PalindromeLinkedList list = new PalindromeLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        list.printLL();

        if (list.checkPalindrome()) {
            System.out.println("Linked List is Palindrome");
        } else {
            System.out.println("Linked List is NOT Palindrome");
        }
    }
}
