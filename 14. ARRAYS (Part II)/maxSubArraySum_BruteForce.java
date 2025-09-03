//! Print Subarrays sum: BruteForce Approach

public class maxSubArraySum_BruteForce {
    public static void SubArraySumPrint(int numbers[]) {
        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;
        System.out.print("\n> Current Sum: ");
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currentSum = 0;
                for (int k = start; k <= end; k++) {
                    // subarrays sum
                    currentSum = currentSum + numbers[k];
                }
                System.out.print(currentSum + " ");
                if (maximumSum < currentSum) {
                    maximumSum = currentSum;
                }
            }
        }
        System.out.println("\n> Maximum Sum: " + maximumSum);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10 };
        SubArraySumPrint(numbers);
    }
}
