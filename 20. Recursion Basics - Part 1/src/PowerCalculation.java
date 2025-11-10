// Calculate x to the power n using recursion

public class PowerCalculation {
    // Recursive method to calculate x^n
    public static int power(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;  // anything power 0 is 1
        }

        // Recursive case
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;

        int result = power(x, n);
        System.out.println(x + " raised to the power " + n + " is: " + result);
    }
}
