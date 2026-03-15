/*
 Detect & Remove Cycle in Linked List
 Using Floyd’s Cycle Finding Algorithm
*/

public class CycleLinkedList2 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    // Print limited nodes (useful when cycle exists)
    public static void printListLimited(int limit) {
        Node temp = head;
        int count = 0;

        while (temp != null && count < limit) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println("...");
    }

    // Print normal linked list (no cycle)
    public static void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Floyd’s Cycle Detection
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Remove Cycle
    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) return;

        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null; // break the cycle
    }

    public static void main(String[] args) {

        // Create Cycle Linked List
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        temp.next = new Node(3);
        temp.next.next = temp; // cycle

        System.out.println("Before removing cycle:");
        printListLimited(10);

        System.out.println("Cycle present? " + isCycle());

        removeCycle();

        System.out.println("\nAfter removing cycle:");
        printList();

        System.out.println("Cycle present? " + isCycle());
    }
}
