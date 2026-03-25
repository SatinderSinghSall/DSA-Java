/*
 Detect Cycle in Linked List
 Using Floyd’s Cycle Finding Algorithm
*/

public class CycleLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    // Floyd’s Cycle Detection
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps

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

        if (!cycle) {
            return;
        }

        slow = head;
        Node prev = null;

        // find starting point of cycle
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;
    }

    public static void main(String[] args) {

        // Create Cycle Linked List
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        temp.next = new Node(3);

        // create cycle
        temp.next.next = temp;

        System.out.println("Cycle present: " + isCycle());

        removeCycle();

        System.out.println("Cycle present after removal: " + isCycle());
    }
}
