// Java: Bit Manipulation - All Bit Operations

public class BitOperations {
    public static void main(String[] args) {
        int n = 10; // Binary: 1010
        int i = 1;  // Bit position (counting from 0, rightmost = 0)

        System.out.println("Java: Bit Manipulation (All Operations)\n");
        System.out.println("n = " + n + " (" + toBinary(n) + ")");
        System.out.println("Bit position i = " + i + "\n");

        // Create bit mask for i-th bit
        int bitMask = 1 << i;

        // 1️⃣ Get i-th Bit
        int getBit = (n & bitMask) == 0 ? 0 : 1;
        System.out.println("1️⃣ Get Bit → " + getBit);

        // 2️⃣ Set i-th Bit (force it to 1)
        int setBit = n | bitMask;
        System.out.println("2️⃣ Set Bit → " + setBit + " (" + toBinary(setBit) + ")");

        // 3️⃣ Clear i-th Bit (force it to 0)
        int clearBit = n & ~bitMask;
        System.out.println("3️⃣ Clear Bit → " + clearBit + " (" + toBinary(clearBit) + ")");

        // 4️⃣ Update i-th Bit
        int newBit = 0; // change this to 1 or 0 to test
        int updateBit = (newBit == 1) ? (n | bitMask) : (n & ~bitMask);
        System.out.println("4️⃣ Update Bit → " + updateBit + " (" + toBinary(updateBit) + ")");

        // 5️⃣ Toggle i-th Bit (flip 0→1 or 1→0)
        int toggleBit = n ^ bitMask;
        System.out.println("5️⃣ Toggle Bit → " + toggleBit + " (" + toBinary(toggleBit) + ")");

        // 6️⃣ Check if a number is Power of Two
        boolean isPowerOfTwo = (n & (n - 1)) == 0;
        System.out.println("6️⃣ Is " + n + " a Power of Two? → " + isPowerOfTwo);
    }

    // Helper method to show 8-bit binary format
    private static String toBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
    }
}
