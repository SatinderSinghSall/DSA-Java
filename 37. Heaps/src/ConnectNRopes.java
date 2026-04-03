// Heap Data Structure: Connect N Ropes with Minimum Cost Problems Solution.

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static int minCost(int[] ropes) {
        // Step 1: Create a Min Heap (PriorityQueue in Java)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 2: Add all rope lengths to the heap
        for (int rope : ropes) {
            pq.add(rope);
        }

        int cost = 0;

        // Step 3: Keep connecting ropes until one remains
        while (pq.size() > 1) {

            // Take two smallest ropes
            int first = pq.poll();
            int second = pq.poll();

            // Cost to connect them
            int sum = first + second;

            // Add to total cost
            cost += sum;

            // Add the new rope back to heap
            pq.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println("Heap Data Structure: Connect N Ropes with Minimum Cost Problems Solution.");

        int[] ropes = {4, 3, 2, 6};

        // Calling function
        int result = minCost(ropes);

        System.out.println("Minimum cost to connect ropes = " + result);
    }
}
