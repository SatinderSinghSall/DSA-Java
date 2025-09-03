//! LeetCode: Problem -> 42. Trapping Rain Water

/*
 * == Algorithm Steps: ==
 * Step - 1: calculate left-max boundary - array:

 * Step - 2: calculate right-max boundary - array:

 * Step - 3: Loop: Algorithm Calculation
 *           > waterLevel = min(leftMaxBoundary - rightMaxBoundary)
 *           > rappedWater = waterLevel - height[i]
*/

public class trappingRainWater {
    public static int TrappedRainWater(int height[]) {
        int length = height.length;

        // 1. calculate left-max boundary - array:
        int leftMaximumBoundary[] = new int[length];
        leftMaximumBoundary[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMaximumBoundary[i] = Math.max(height[i], leftMaximumBoundary[i - 1]);
        }

        // 2. calculate right-max boundary - array:
        int rightMaximumBoundary[] = new int[length];
        rightMaximumBoundary[length - 1] = height[length - 1]; // to get the last index
        for (int j = length - 2; j >= 0; j--) {
            rightMaximumBoundary[j] = Math.max(height[j], rightMaximumBoundary[j + 1]);
        }

        // 3. loop: Algo Calculation
        int trappedWater = 0;
        for (int k = 0; k < length; k++) {
            int waterLevel = Math.min(leftMaximumBoundary[k], rightMaximumBoundary[k]);
            trappedWater = trappedWater + waterLevel - height[k];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int trappedWater = TrappedRainWater(height);
        System.out.println("\nThe trap water is: " + trappedWater);
    }
}
