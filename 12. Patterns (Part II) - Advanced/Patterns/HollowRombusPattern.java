// Hollow Rombus Pattern:

package Patterns;

public class HollowRombusPattern {
    public static void Print_HollowRombusPattern(int num) {
        for(int i = 1; i <= num; i ++) {
            // Spaces:
            for(int j = 1; j <= num - i; j ++) {
                System.out.print(" ");
            }

            // Hollow Rectangle:
            for(int j = 1; j <= num; j ++) {
                if(i == 1 || i == num || j == 1 || j == num) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(" " + " ");
                }
            }

            // New Line:
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_HollowRombusPattern(5);
    }
}
