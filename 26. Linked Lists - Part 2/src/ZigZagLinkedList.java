// Problem Name: Zig Zag Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ZigZagLinkedList {
    public static Node zigZag(Node head) {
        if (head == null || head.next == null) return head;

        // Step 1: Find middle
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node curr = slow.next;
        slow.next = null;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Merge alternately
        Node left = head, right = prev;
        while (right != null) {
            Node nextL = left.next;
            Node nextR = right.next;

            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Problem: Zig Zag Linked List...");

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = zigZag(head);
        print(head);
    }
}
