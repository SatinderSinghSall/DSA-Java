//! Decimal to Binary: Code - Java

public class decimalToBinary {
    public static void decimalToBinaryCalculation(int decimalNumber) {
        int myDecimalNumber = decimalNumber;
        int power = 0;
        int binaryNumber = 0;
        while (decimalNumber > 0) {
            int reminder = decimalNumber % 2;
            binaryNumber = binaryNumber + (reminder * (int) Math.pow(10, power));
            power++;
            decimalNumber = decimalNumber / 2;
        }
        System.out.println("\nThe binary form of " + myDecimalNumber + " is: " + binaryNumber);
    }

    public static void main(String[] args) {
        decimalToBinaryCalculation(7);
    }
}
