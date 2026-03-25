// Problem Name: Doubly Linked List

class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {
    static DNode head;

    public static void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        DNode temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    public static void print() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Problem: Doubly Linked List...");

        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);

        print();
    }
}
