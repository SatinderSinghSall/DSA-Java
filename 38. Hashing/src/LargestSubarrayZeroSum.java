// Hashing: Largest Subarray with Sum = 0

import java.util.HashMap;

public class LargestSubarrayZeroSum {
    public static void main(String[] args) {
        System.out.println("Hashing: Largest Subarray with Sum = 0");

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: sum becomes 0
            if (sum == 0) {
                maxLen = i + 1;
            }

            // Case 2: sum seen before
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(sum, i); // store first occurrence
            }
        }

        System.out.println("Largest subarray length: " + maxLen);
    }
}
