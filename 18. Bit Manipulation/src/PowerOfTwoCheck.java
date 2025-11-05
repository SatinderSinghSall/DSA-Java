// Java: Check if a Number is Power of 2 using Bit Manipulation

public class PowerOfTwoCheck {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 8};

        System.out.println("Java: Check if a Number is a Power of 2\n");

        for (int n : numbers) {
            System.out.println("n = " + n + " (" + toBinary(n) + ") → " +
                    (isPowerOfTwo(n) ? "Power of 2 ✅" : "Not Power of 2 ❌"));
        }
    }

    // Function to check Power of 2
    public static boolean isPowerOfTwo(int n) {
        // 0 or negative numbers are not powers of 2
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    // Helper: show 8-bit binary
    private static String toBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
    }
}
