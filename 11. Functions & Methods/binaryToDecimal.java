//! Binary to Decimal: Code - Java
 
public class binaryToDecimal {
    public static void binaryToDecimalCalculation(int binaryNumber) {
        int myBinaryNumber = binaryNumber;
        int power = 0;
        int decimalNumber = 0;
        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            decimalNumber = decimalNumber + (lastDigit * (int) Math.pow(2, power));
            power++;
            binaryNumber = binaryNumber / 10;
        }
        System.out.println("\nDecimal of binary number " + myBinaryNumber + " is: " + decimalNumber);
    }

    public static void main(String[] args) {
        binaryToDecimalCalculation(111);
    }
}
