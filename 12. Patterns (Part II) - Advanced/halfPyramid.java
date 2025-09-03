//! Inverted and Rotated Half-Pyramid: Java
 
public class halfPyramid {
    public static void invertedRotatedHalfPyramid(int n) {
        // outer-loop:
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // stats
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(); // next-line
        }
    }

    public static void main(String[] args) {
        invertedRotatedHalfPyramid(10);
    }
}
