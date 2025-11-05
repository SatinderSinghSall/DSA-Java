// Java: Fast Exponentiation using Bit Manipulation

public class FastExponentiation {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        System.out.println("Java: Fast Exponentiation (a^b using Bit Manipulation)\n");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Binary of b = " + toBinary(b) + "\n");

        int result = power(a, b);
        System.out.println(a + "^" + b + " = " + result);
    }

    // Function to calculate a^b efficiently
    public static int power(int a, int b) {
        int result = 1;

        while (b > 0) {
            if ((b & 1) != 0) {   // If last bit of b is 1
                result *= a;
            }
            a = a * a;  // Square the base
            b = b >> 1; // Shift b to process next bit
        }

        return result;
    }

    // Helper: binary representation (8 bits)
    private static String toBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
    }
}
