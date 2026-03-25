// Problem Name: Circular Linked List

class Node2 {
    int data;
    Node next;

    Node2(int data) {
        this.data = data;
    }
}

public class CircularLinkedList {
    static Node head;

    public static void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    public static void print() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(head)");
    }

    public static void main(String[] args) {
        System.out.println("Problem: Circular Linked List...");

        insert(1);
        insert(2);
        insert(3);

        print();
    }
}
