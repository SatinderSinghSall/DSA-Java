// Find the factorial of n using recursion

public class Factorial {
    // Recursive method to find factorial
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: n! = n × (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;  // You can change this value to test
        int result = factorial(n);

        System.out.println("Factorial of " + n + " is: " + result);
    }
}
