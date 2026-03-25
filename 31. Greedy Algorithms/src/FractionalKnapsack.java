// Greedy Algorithm Problem - Fractional Knapsack.

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        System.out.println("Greedy Algorithm Problem - Fractional Knapsack.");

        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        int n = value.length;

        // Step 1: Store indices
        Integer idx[] = new Integer[n];

        // Step 2: Calculate ratio
        double ratio[] = new double[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
            ratio[i] = value[i] / (double) weight[i];
        }

        // Step 3: Sort indices based on ratio (descending)
        Arrays.sort(idx, (a, b) -> Double.compare(ratio[b], ratio[a]));

        // Step 4: Apply greedy approach
        int capacity = W;
        double finalValue = 0;

        for (int i = 0; i < n; i++) {
            int id = idx[i];

            if (capacity >= weight[id]) {
                // take full item
                finalValue += value[id];
                capacity -= weight[id];
            } else {
                // take fractional item
                finalValue += ratio[id] * capacity;
                break;
            }
        }

        // Step 5: Output result
        System.out.println("Final Value: " + finalValue);
    }
}
