// Java: Check Odd or Even using Bit Manipulation

public class OddEven_Number {
    public static void main(String[] args) {
        int num1 = 6;  // Binary: 0110
        int num2 = 7;  // Binary: 0111

        System.out.println("Java: Odd or Even Check using Bit Manipulation\n");

        checkOddEven(num1);
        checkOddEven(num2);
    }

    // Function to check if a number is odd or even
    public static void checkOddEven(int number) {
        // Using Bitwise AND with 1
        if ((number & 1) == 0) {
            System.out.println(number + " is EVEN (Binary: " + toBinary(number) + ")");
        } else {
            System.out.println(number + " is ODD  (Binary: " + toBinary(number) + ")");
        }
    }

    // Helper method to format binary representation
    private static String toBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
    }
}
