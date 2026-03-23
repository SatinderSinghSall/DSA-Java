// Queue: Queue Reversal.

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1); q.add(2); q.add(3);

        Stack<Integer> s = new Stack<>();

        // Step 1: Queue → Stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        // Step 2: Stack → Queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        System.out.println(q);
    }
}
