// Print numbers in decreasing and increasing order from n to 1 and 1 to n

public class PrintNumbers {
    // Print numbers in decreasing order
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n - 1);
    }

    // Print numbers in increasing order
    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Decreasing Order:");
        printDecreasing(n);

        System.out.println("\n\nIncreasing Order:");
        printIncreasing(n);
    }
}
