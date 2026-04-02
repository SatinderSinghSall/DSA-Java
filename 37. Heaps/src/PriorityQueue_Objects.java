// Heaps / Priority Queue: Priority Queue for Objects.

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_Objects {
    public static void main(String[] args) {
        System.out.println("Heaps / Priority Queue: Priority Queue for Objects.");

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3); // Time Complexity: O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " "); // Time Complexity: O(1)
            pq.remove(); // Time Complexity: O(logn)
        }
    }
}
