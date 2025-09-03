//! Floyd's Triangle: Java

public class floydsTriangle {
    public static void floydsTrianglePattern(int n) {
        int counter = 1;
        // outer-loop:
        for (int i = 1; i <= n; i++) {
            // inner-loop:
            for (int j = 1; j <= i; j++) { // no of times counter be printed!
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        floydsTrianglePattern(5);
    }
}
