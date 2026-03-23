// Queue: Interleave Two Halves of a Queue.

import java.util.*;

public class InterleaveQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 6; i++) {
            q.add(i);
        }

        int size = q.size();
        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: store first half
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: interleave
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

        System.out.println(q);
    }
}
