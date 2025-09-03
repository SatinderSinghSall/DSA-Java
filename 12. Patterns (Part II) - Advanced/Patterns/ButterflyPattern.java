// Butterfly Pattern:

package Patterns;

public class ButterflyPattern {
    public static void Print_ButterflyPattern(int num) {
        // First Half
        for (int i = 1; i <= num; i++) {
            // Left Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Middle Spaces
            for (int j = 1; j <= 2 * (num - i); j++) {
                System.out.print("  "); // double space to match "* "
            }

            // Right Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Second Half
        for (int i = num; i >= 1; i--) {
            // Left Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Middle Spaces
            for (int j = 1; j <= 2 * (num - i); j++) {
                System.out.print("  ");
            }

            // Right Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_ButterflyPattern(5);
    }
}
