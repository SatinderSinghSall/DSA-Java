// Greedy Algorithm Problem - Minimum Length Chain of Pairs.

// Greedy Algorithm Problem - Maximum Length Chain of Pairs
// Problem: Given a set of pairs (a, b) where a < b, find the longest chain
// such that for pair (c, d) to follow (a, b), we must have b < c.

import java.util.Arrays;

public class MaxLenChainPairs {

    public static void main(String[] args) {
        int[][] pairs = {
                {5, 24},
                {15, 25},
                {27, 40},
                {50, 60}
        };

        System.out.println("Maximum Length Chain: " + maxChainLength(pairs));
    }

    public static int maxChainLength(int[][] pairs) {

        // Step 1: Sort pairs based on second element (end time)
        // This is the greedy choice: always pick the pair that ends earliest
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        // Step 2: Initialize count and track last selected pair's end
        int count = 1; // At least one pair can always be selected
        int lastEnd = pairs[0][1];

        // Step 3: Iterate through remaining pairs
        for (int i = 1; i < pairs.length; i++) {

            // If current pair can follow the last selected pair
            if (pairs[i][0] > lastEnd) {
                count++; // Include this pair in chain
                lastEnd = pairs[i][1]; // Update last end
            }
        }

        return count;
    }
}
