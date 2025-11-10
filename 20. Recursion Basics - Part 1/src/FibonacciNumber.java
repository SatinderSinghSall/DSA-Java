// Print Nth Fibonacci number using recursion

public class FibonacciNumber {
    // Recursive method to find the Nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // Find the 10th Fibonacci number
        int result = fibonacci(n);

        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
