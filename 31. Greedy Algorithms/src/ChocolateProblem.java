// Greedy Algorithm Problem - Chocolate Problem.

// Problem: Given costs of vertical and horizontal cuts,
// find the minimum cost to break the chocolate into 1x1 squares.

import java.util.*;

public class ChocolateProblem {

    public static void main(String[] args) {

        // Example:
        // vertical cuts (x): cost of cutting columns
        // horizontal cuts (y): cost of cutting rows

        Integer[] x = {2, 1, 3, 1, 4}; // vertical cuts
        Integer[] y = {4, 1, 2};       // horizontal cuts

        System.out.println("Minimum Cost: " + minCost(x, y));
    }

    public static int minCost(Integer[] x, Integer[] y) {

        // Step 1: Sort both arrays in descending order
        // Greedy choice: always pick the highest cost cut first
        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());

        int h = 1; // number of horizontal pieces
        int v = 1; // number of vertical pieces

        int i = 0, j = 0;
        int cost = 0;

        // Step 2: Process cuts
        while (i < x.length && j < y.length) {

            // If vertical cut cost is higher
            if (x[i] > y[j]) {
                cost += x[i] * h; // multiply by current horizontal pieces
                v++;              // increase vertical pieces
                i++;
            } else {
                cost += y[j] * v; // multiply by current vertical pieces
                h++;              // increase horizontal pieces
                j++;
            }
        }

        // Step 3: Remaining cuts (if any)

        // Remaining vertical cuts
        while (i < x.length) {
            cost += x[i] * h;
            v++;
            i++;
        }

        // Remaining horizontal cuts
        while (j < y.length) {
            cost += y[j] * v;
            h++;
            j++;
        }

        return cost;
    }
}
