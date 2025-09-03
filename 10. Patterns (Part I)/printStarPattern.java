//! Print STAR pattern: Java

public class printStarPattern {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            // one-line:
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
