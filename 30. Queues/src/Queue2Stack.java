// Queue: Implementing a Queue using 2 Stacks.

import java.util.Stack;

public class Queue2Stack {
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Enqueue (O(1))
        void enqueue(int x) {
            s1.push(x);
        }

        // Dequeue (Amortized O(1))
        int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }

        // Peek front element
        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }

        // Check if queue is empty
        boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("Queue: Implementing a Queue using 2 Stacks.");

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());       // 20
        System.out.println("Dequeued: " + q.dequeue()); // 20
    }
}
