// Diamond Pattern:

package Patterns;

public class DiamondPattern {
    public static void Print_DiamondPattern(int num) {
        // First Half of Diamond:
        for (int i = 1; i <= num; i++) {
            // Printing Spaces:
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" " + " ");
            }

            // Printing Stars:
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*" + " ");
            }

            // Next Line:
            System.out.println();
        }

        // Second Half of Diamond:
        for (int i = num - 1; i >= 1; i--) {
            // Printing Spaces:
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" " + " ");
            }

            // Printing Stars:
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*" + " ");
            }

            // Next Line:
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_DiamondPattern(5);
    }
}
