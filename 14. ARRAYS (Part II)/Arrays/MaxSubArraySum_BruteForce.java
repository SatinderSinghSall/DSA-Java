// Topic: Maximum Subarray Sum - Brute Force Approach:

package Arrays;

public class MaxSubArraySum_BruteForce {
    public static void PrintSubarraySum(int numbers[]) {
        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        for(int i = 0; i < numbers.length; i ++) {
            int start = i;
            for(int j = i; j < numbers.length; j ++) {
                int end = j;
                currentSum = 0;

                for(int k = start; k <= end; k ++) {
                    // Subarray Sum:
                    currentSum = currentSum + numbers[k];
                }

                System.out.print(currentSum + " ");

                if(maximumSum < currentSum) {
                    maximumSum = currentSum;
                }
            }
        }
        System.out.println("\nMaximum Subarray Sum: " + maximumSum);
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};

        PrintSubarraySum(numbers);
    }
}
