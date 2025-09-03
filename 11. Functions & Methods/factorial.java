//! Factorial of a number n: Java

public class factorial {
    public static int calculateFactorial(int n) {
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }

        return factorial; // factorial of n
    }

    public static void main(String[] args) {
        int n = 5;
        int result = calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
