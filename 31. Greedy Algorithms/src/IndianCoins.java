// Greedy Algorithm Problem - Minimum Number of Coins. (Indian Coins)

// Problem: Given an infinite supply of denominations
// [1, 2, 5, 10, 20, 50, 100, 500, 2000],
// find the minimum number of coins/notes required to make a value V.

import java.util.*;

public class IndianCoins {

    public static void main(String[] args) {

        int value = 590;

        System.out.println("Minimum Coins Required: " + minCoins(value));
    }

    public static int minCoins(int V) {

        // Step 1: Define denominations in descending order
        // Greedy choice: always pick the largest denomination first
        int[] coins = {2000, 500, 100, 50, 20, 10, 5, 2, 1};

        int count = 0; // To store total number of coins

        // Step 2: Traverse through each denomination
        for (int i = 0; i < coins.length; i++) {

            // While we can still use this coin
            while (V >= coins[i]) {
                V -= coins[i]; // reduce value
                count++;       // increase coin count
            }
        }

        return count;
    }
}
