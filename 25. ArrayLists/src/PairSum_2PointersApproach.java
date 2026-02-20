// Pair Sum (Sorted) - 2 Pointers Approach

import java.util.ArrayList;
import java.util.Arrays;

public class PairSum_2PointersApproach {

    // Method to check if pair exists
    public static boolean hasPair(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        // Time Complexity: O(n)
        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                System.out.println("Pair found: " + list.get(left) + " + " + list.get(right) + " = " + target);
                return true;
            }
            else if (sum < target) {
                left++;   // move left pointer right
            }
            else {
                right--;  // move right pointer left
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 8, 9)); // sorted list
        int target = 10;

        if (!hasPair(list, target)) {
            System.out.println("No pair found.");
        }
    }
}