// Inverted and Rotated Half-Pyramid Patten: Java

package Patterns;

public class HalfPyramid {
    public static void Print_HalfPyramid(int n) {
        // Outer Loop: Row / Lines
        for(int i = 1; i <=n; i ++) {
            // Inner Loop - 1: Empty Spaces
            for(int j = 1; j <= n - i; j ++) {
                System.out.print(" " + " ");
            }

            // Inner Loop - 2: Stars
            for(int k = 1; k <= i; k ++) {
                System.out.print("*" + " ");
            }

            // New Line:
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_HalfPyramid(4);
    }
}
