// Queue: Implementing a Stack using 2 Queues.

import java.util.LinkedList;
import java.util.Queue;

public class Stack2Queues {

    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Push (O(n))
        void push(int x) {
            // Step 1: Add new element to q2
            q2.add(x);

            // Step 2: Move all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // Step 3: Swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        // Pop (O(1))
        int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.remove();
        }

        // Peek (Top element)
        int peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.peek();
        }

        // Check if empty
        boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack: Implementing using 2 Queues.");

        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top: " + s.peek());   // 30
        System.out.println("Popped: " + s.pop()); // 30
        System.out.println("Top: " + s.peek());   // 20
    }
}
