// Dynamic Programming: Given a positive integer n, find the nth Fibonacci number.

public class FibonacciNumber {
    public static int fibonacci(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (f[n] != 0) {
            return f[n];
        }

        f[n] = fibonacci(n - 1, f) + fibonacci(n - 2, f);

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println("Dynamic Programming: Given a positive integer n, find the nth Fibonacci number.");

        int n = 5;
        int f[] = new int[n + 1];

        System.out.println(fibonacci(n, f));
    }
}
