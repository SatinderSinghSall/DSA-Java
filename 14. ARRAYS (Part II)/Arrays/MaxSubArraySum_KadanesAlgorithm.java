// Topic: Maximum Subarray Sum - Kadane's Algorithm Approach:

package Arrays;

public class MaxSubArraySum_KadanesAlgorithm {
    public static void KadaneAlgorithm(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int currrentSum = 0;

        for(int i = 0; i < numbers.length; i ++) {
            currrentSum = currrentSum + numbers[i];
            if(currrentSum < 0) {
                currrentSum = 0;
            }
            maxSum = Math.max(currrentSum, maxSum);
        }

        System.out.println("Maximum Subarray is: " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        KadaneAlgorithm(numbers);
    }
}
