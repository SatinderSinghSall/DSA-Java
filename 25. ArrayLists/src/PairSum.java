// Find if any pair in a sorted & rotated ArrayList has a given target sum.

import java.util.ArrayList;
import java.util.Arrays;

public class PairSum {

    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int n = list.size();

        // Step 1: find pivot (largest element index)
        int pivot = -1;
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        // Step 2: set pointers
        int left = (pivot + 1) % n; // smallest
        int right = pivot;          // largest

        // Step 3: circular two pointer search
        while (left != right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                System.out.println("Pair: " + list.get(left) + " + " + list.get(right));
                return true;
            }

            if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list =
                new ArrayList<>(Arrays.asList(11, 15, 6, 8, 9, 10));

        int target = 16;

        System.out.println(pairSum(list, target));
    }
}
