// Graphs: Flood Fill Algorithm

import java.util.*;

public class FloodFill {

    public static void helper(int[][] image, int sr, int sc, int color,
                              boolean vis[][], int originalColor) {

        int n = image.length;
        int m = image[0].length;

        // boundary check
        if(sr < 0 || sc < 0 || sr >= n || sc >= m) {
            return;
        }

        // already visited
        if(vis[sr][sc]) {
            return;
        }

        // different color
        if(image[sr][sc] != originalColor) {
            return;
        }

        // mark visited
        vis[sr][sc] = true;

        // change color
        image[sr][sc] = color;

        // explore neighbors
        helper(image, sr+1, sc, color, vis, originalColor);
        helper(image, sr-1, sc, color, vis, originalColor);
        helper(image, sr, sc+1, color, vis, originalColor);
        helper(image, sr, sc-1, color, vis, originalColor);
    }

    // Flood Fill Method
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        boolean vis[][] = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, vis, originalColor);

        return image;
    }

    public static void main(String args[]) {

        int image[][] = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int ans[][] = floodFill(image, sr, sc, color);

        for(int i=0;i<ans.length;i++) {
            for(int j=0;j<ans[0].length;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
