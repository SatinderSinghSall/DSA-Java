// Queue: Implement Queue using Deque.

import java.util.*;

public class QueueUsingDeque {
    static class Queue {
        Deque<Integer> dq = new LinkedList<>();

        void add(int x) {
            dq.addLast(x);
        }

        int remove() {
            return dq.removeFirst();
        }

        int peek() {
            return dq.peekFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);

        System.out.println(q.remove()); // 10
    }
}
