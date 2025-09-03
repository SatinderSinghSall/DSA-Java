//! Print Subarrays sum: Prefix Sum Approach

public class maxSubArraySum_PrefixSum {
    public static void SubArraySumPrint(int numbers[]) {
        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        // calculate prefix array:
        for (int k = 1; k < prefix.length; k++) {
            prefix[k] = prefix[k - 1] + numbers[k];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;

                currentSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maximumSum < currentSum) {
                    maximumSum = currentSum;
                }
            }
        }

        System.out.println("\n> Maximum Sum: " + maximumSum);
    }

    public static void main(String[] args) {
        int numbers[] = { 0, -2, 6, -1, 3 };
        SubArraySumPrint(numbers);
    }
}
