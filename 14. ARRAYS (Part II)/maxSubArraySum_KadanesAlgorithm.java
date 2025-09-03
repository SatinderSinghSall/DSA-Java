//! Print Subarrays sum: Kadane's Algorithm Approach

public class maxSubArraySum_KadanesAlgorithm {
    public static void SubArraySumPrint(int numbers[]) {
        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            currentSum = currentSum + numbers[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maximumSum = Math.max(maximumSum, currentSum);
        }
        System.out.println("\nMaximum Sum: " + maximumSum);
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        SubArraySumPrint(numbers);
    }
}
