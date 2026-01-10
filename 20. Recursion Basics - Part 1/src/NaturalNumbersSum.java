// Print sum of n natural numbers using recursion

public class NaturalNumbersSum {
    // Recursive method to find sum of n natural numbers
    public static int sum(int n) {
        // Base case: when n becomes 0, stop recursion
        if (n == 0) {
            return 0;
        }

        // Recursive case: sum(n) = n + sum(n - 1)
        return n + sum(n - 1);
    }

    public static int sum2(int n) {
        if(n == 1) {
            return 1;
        }
        int snm1 = sum2(n - 1);
        int sn = n + snm1;
        return sn;
    }

    public static void main(String[] args) {
        int n = 10;  // You can change this value
        int result = sum(n);

        System.out.println("Sum of first " + n + " natural numbers is: " + result);

        System.out.println(sum2(n));
    }
}
