// Hashing: Count Subarrays with Sum = K

import java.util.HashMap;

public class SubarraySumK {
    public static void main(String[] args) {
        System.out.println("Hashing: Count Subarrays with Sum = K");

        int[] arr = {1, 2, 3};
        int K = 3;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // important

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // check if (sum - K) exists
            if (map.containsKey(sum - K)) {
                count += map.get(sum - K);
            }

            // store frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Number of subarrays: " + count);
    }
}
