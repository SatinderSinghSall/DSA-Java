//! Square pattern: Java

public class patternSquare {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            System.out.println("* * * *");
        }

        System.out.println("\n");

        int j = 1;
        while (j <= 5) {
            System.out.println("* * * * *");
            j++;
        }
    }
}
