// Heap Data Structure: Sliding Window Maximum.

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // Result array
        int[] result = new int[nums.length - k + 1];

        // Deque to store indices
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            // Step 1: Remove elements smaller than current from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(j);

            // Step 2: Remove elements out of window (i.e., j-k)
            if (dq.peekFirst() <= j - k) {
                dq.pollFirst();
            }

            // Step 3: Store result when window size reached
            if (j >= k - 1) {
                result[i++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;

        int[] ans = maxSlidingWindow(nums, k);

        System.out.print("Sliding window max: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
