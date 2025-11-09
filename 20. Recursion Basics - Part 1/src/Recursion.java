// Recursive method to print numbers from 1 to n

public class Recursion {
    static void printNumbers(int n) {
        // Base Case (stopping condition)
        if (n == 0) {
            return;
        }

        // Recursive call to print smaller problem
        printNumbers(n - 1);

        // Action (executed during the "unwinding" phase)
        System.out.println(n);
    }

    public static void main(String[] args) {
        printNumbers(5); // call the function with n = 5
    }
}
