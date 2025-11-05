// Java: Bit Manipulation

public class BitManipulation {
    public static void main(String[] args) {
        int a = 6;   // Binary: 0000 0110
        int b = 3;   // Binary: 0000 0011

        System.out.println("Java: Bit Manipulation\n");

        System.out.println("a = " + a + " (" + toBinary(a) + ")");
        System.out.println("b = " + b + " (" + toBinary(b) + ")\n");

        // 1. Bitwise AND
        int andResult = a & b; // 0110 & 0011 = 0010 (2)
        System.out.println("a & b = " + andResult + " (" + toBinary(andResult) + ")");

        // 2. Bitwise OR
        int orResult = a | b; // 0110 | 0011 = 0111 (7)
        System.out.println("a | b = " + orResult + " (" + toBinary(orResult) + ")");

        // 3. Bitwise XOR
        int xorResult = a ^ b; // 0110 ^ 0011 = 0101 (5)
        System.out.println("a ^ b = " + xorResult + " (" + toBinary(xorResult) + ")");

        // 4. Bitwise NOT (One's Complement)
        int onesComplement = ~a; // ~0110 = 11111111111111111111111111111001 (-7)
        System.out.println("~a (One's Complement) = " + onesComplement + " (" + toBinary(onesComplement) + ")");

        // 5. Left Shift (<<)
        int leftShift = a << 1; // 0110 << 1 = 1100 (12)
        System.out.println("a << 1 = " + leftShift + " (" + toBinary(leftShift) + ")");

        // 6. Right Shift (>>)
        int rightShift = a >> 1; // 0110 >> 1 = 0011 (3)
        System.out.println("a >> 1 = " + rightShift + " (" + toBinary(rightShift) + ")");

        // 7. Unsigned Right Shift (>>>)
        int unsignedRightShift = a >>> 1; // Same as >> for positive numbers
        System.out.println("a >>> 1 = " + unsignedRightShift + " (" + toBinary(unsignedRightShift) + ")");
    }

    // Helper method to format binary numbers as 8-bit (or 32-bit) strings
    private static String toBinary(int n) {
        String binary = Integer.toBinaryString(n);
        // pad to 32 bits for clarity
        return String.format("%32s", binary).replace(' ', '0');
    }
}
