// Topic: Maximum Subarray Sum - Prefix Sum Approach:

package Arrays;

public class MaxSubArraySum_PrefixSum {
    public static void PrintSubarraySum(int numbers[]) {
        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        // Calculate Prefix Array:
        for(int i = 1; i < prefix.length; i ++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for(int i = 0; i < numbers.length; i ++) {
            int start = i;
            for(int j = i; j < numbers.length; j ++) {
                int end = j;
                currentSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                System.out.print(currentSum + " ");

                if(maximumSum < currentSum) {
                    maximumSum = currentSum;
                }
            }
        }
        System.out.println("\nMaximum Subarray Sum: " + maximumSum);
    }

    public static void main(String[] args) {
        int numbers[] = {0, -2, 6, -1, 3};

        PrintSubarraySum(numbers);
    }
}
