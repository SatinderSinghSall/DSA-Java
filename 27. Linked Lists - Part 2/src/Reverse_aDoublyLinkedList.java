// Problem Name: Reverse a Doubly Linked List

class DNode2 {
    int data;
    DNode prev, next;

    DNode2(int data) {
        this.data = data;
    }
}

public class Reverse_aDoublyLinkedList {
    public static DNode reverse(DNode head) {
        DNode temp = null;
        DNode curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null) head = temp.prev;

        return head;
    }

    public static void print(DNode head) {
        while (head != null) {
            System.out.print(head.data + " <-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Problem: Reverse Doubly Linked List...");

        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        head = reverse(head);
        print(head);
    }
}
