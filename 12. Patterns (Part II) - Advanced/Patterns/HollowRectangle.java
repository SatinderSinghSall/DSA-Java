package Patterns;

public class HollowRectangle {
    public static void Hollow_Rectangle(int totRow, int totCol) {
        // Outer Loop:
        for(int i = 1; i <= totRow; i ++) {
            // Inner Loop:
            for(int j = 1; j <= totCol; j ++) {
                // Cell - (i , j)
                if(i == 1 || i == totRow || j == 1 || j == totCol) {
                    // Boundary Cell:
                    System.out.print("*" + " ");
                } else {
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Hollow_Rectangle(4, 5);
    }
}
