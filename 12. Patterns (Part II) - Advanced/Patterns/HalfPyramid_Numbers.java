// Inverted Half Pyramid with Numbers:

package Patterns;

public class HalfPyramid_Numbers {
    public static void Print_Pattern(int num) {
        for(int i = 1; i <= num; i ++) {
            for(int j = 1; j <= num - i + 1; j ++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_Pattern(5);
    }
}
