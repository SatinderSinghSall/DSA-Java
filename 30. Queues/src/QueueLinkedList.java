// Queue: Implementing a Queue using a Linked List.

public class QueueLinkedList {
    public static class Queue {
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        static  Node head = null;
        static Node tail = null;

        // Method to check if Queue is Empty.
        public static boolean isEmpty() {
            return head == null && tail == null;
        }
        // Time: O(1)
        // Space: O(1)

        // Add Method:
        public static void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }
        // Time: O(1)
        // Space: O(1)

        // Remove Method:
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }

            int front = head.data;

            // Single Element in a Linked List or Queue:
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }

            return front;
        }
        // Time: O(1)
        // Space: O(1)

        // Peek Method:
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }

            return head.data;
        }
        // Time: O(1)
        // Space: O(1)
    }

    public static void main(String[] args) {
        System.out.println("Queue: Implementing a Queue using Linked List.");

        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        q.add(4);

        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
