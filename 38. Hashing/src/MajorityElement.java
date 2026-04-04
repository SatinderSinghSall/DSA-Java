// Hashing: Majority Element (> n/3 times)

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {

        // Input array
        int[] nums = {1, 3, 2, 5, 1, 3, 1, 5, 1};

        // Step 1: Create a HashMap to store frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 2: Count frequency of each element
        for (int i = 0; i < nums.length; i++) {

            // If element already exists, increment its count
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            // Otherwise, add element with count 1
            else {
                map.put(nums[i], 1);
            }
        }

        // Step 3: Calculate threshold (n/3)
        int n = nums.length;
        int threshold = n / 3;

        System.out.println("Elements appearing more than n/3 times:");

        // Step 4: Check which elements satisfy the condition
        for (int key : map.keySet()) {

            // If frequency > n/3, print the element
            if (map.get(key) > threshold) {
                System.out.println(key);
            }
        }
    }
}
