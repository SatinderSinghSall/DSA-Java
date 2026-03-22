// Queue: Implementing a Circular Queue & Circular Queue using an Array

public class CircularQueue {
    public static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        // Constructor
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        // Time: O(n)  (array creation)
        // Space: O(n)

        // Method to check if Queue is Empty.
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        // Time: O(1)
        // Space: O(1)

        // Method to check if Queue is Full.
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }
        // Time: O(1)
        // Space: O(1)

        // Add Method:
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full.");
                return;
            }

            // Add first element:
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        // Time: O(1)
        // Space: O(1)

        // Remove Method:
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }

            int result = arr[front];

            // Delete last Element:
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }
        // Time: O(1)
        // Space: O(1)

        // Peek Method:
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty.");
                return -1;
            }

            return arr[front];
        }
        // Time: O(1)
        // Space: O(1)
    }

    public static void main(String[] args) {
        System.out.println("Queue: Implementing a Circular Queue using an Array.");

        Queue q = new Queue(3);

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
