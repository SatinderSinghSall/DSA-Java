//! Inverted Half-Pyramid with Numbers: Java

public class halfPyramidNumbers {
    public static void invertedHalNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // inner-numbers:
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedHalNumberPyramid(5);
    }
}
