// LeetCode - 42. Trapping Rain Water:

package Arrays;

public class LeetCode_TrappingRainWater {
    public static int TrappingRainWater(int height[]) {
        // Calculate Left Max Boundary - array:
        int leftMax[] = new int [height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i ++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Calculate Right Max Boundary - array:
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i --) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Loop: Algo Calculation
        int trapWater = 0;
        for(int i = 0; i < height.length; i ++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trapWater = trapWater + waterLevel - height[i];
        }

        return trapWater;
    }

    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(TrappingRainWater(height));
    }
}
