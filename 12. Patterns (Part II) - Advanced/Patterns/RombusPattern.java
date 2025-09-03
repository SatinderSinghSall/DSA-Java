// Rombus Pattern:

package Patterns;

public class RombusPattern {
    public static void Print_RombusPattern(int num) {
        for(int i = 1; i <= num; i ++) {
            // Spaces:
            for(int j = 1; j <= num - i; j ++) {
                System.out.print(" ");
            }

            // Stars:
            for(int j = 1; j <= num; j ++) {
                System.out.print("*" + " ");
            }

            // Next Line:
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_RombusPattern(5);
    }
}
