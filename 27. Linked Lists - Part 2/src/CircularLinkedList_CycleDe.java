// Problem Name: Detect Cycle in Linked List

class Node3 {
    int data;
    Node next;

    Node3(int data) {
        this.data = data;
    }
}

public class CircularLinkedList_CycleDe {
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Problem: Detect Cycle in Linked List...");

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // create cycle
        head.next.next.next = head;

        System.out.println(hasCycle(head));
    }
}
