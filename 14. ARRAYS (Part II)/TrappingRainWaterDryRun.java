// LeetCode - 42. Trapping Rain Water:

public class TrappingRainWaterDryRun {

    public static int TrappingRainWater(int height[]) {
        int n = height.length;

        // Left max
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Right max
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Calculate water
        int trapWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            int trapped = waterLevel - height[i];
            trapWater += trapped;

            // Print step-by-step state
            System.out.println("Step " + i + " (Index " + i + "):");
            printBars(height, leftMax, rightMax, i, trapped);
            System.out.println("Water trapped at index " + i + " = " + trapped);
            System.out.println("-------------------------------------");
        }

        return trapWater;
    }

    // Helper to print bars and water
    private static void printBars(int[] height, int[] leftMax, int[] rightMax, int idx, int trapped) {
        int n = height.length;
        int maxH = 0;
        for (int h : height) maxH = Math.max(maxH, h);
        int waterLevel = Math.min(leftMax[idx], rightMax[idx]);

        for (int level = maxH; level >= 1; level--) {
            for (int i = 0; i < n; i++) {
                if (height[i] >= level) {
                    System.out.print("# ");
                } else if (i == idx && level <= waterLevel && level > height[i]) {
                    System.out.print("~ "); // show trapped water at current index
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        // base line
        for (int i = 0; i < n; i++) System.out.print("--");
        System.out.println();
        for (int i = 0; i < n; i++) System.out.print(i + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int result = TrappingRainWater(height);
        System.out.println("Total Water Trapped = " + result);
    }
}
