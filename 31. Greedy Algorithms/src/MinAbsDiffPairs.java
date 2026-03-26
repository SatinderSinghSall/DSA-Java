// Greedy Algorithm Problem - Minimum Absolute Difference Pairs.

import java.util.Arrays;

public class MinAbsDiffPairs {
    public static void main(String[] args) {
        System.out.println("Greedy Algorithm Problem - Minimum Absolute Difference Pairs.");

        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i ++) {
            minDiff = minDiff + Math.abs(A[i] - B[i]);
        }

        System.out.println("\nMinimum absolute difference of pairs: " + minDiff);
    }
}
