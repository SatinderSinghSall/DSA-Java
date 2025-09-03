package Practice;

public class MathClass {
    public static void main(String[] args) {
        // a. Math.min(a, b) → Returns smaller of two numbers
        int minValue = Math.min(10, 20);
        System.out.println("Minimum: " + minValue);

        // b. Math.max(a, b) → Returns larger of two numbers
        int maxValue = Math.max(10, 20);
        System.out.println("Maximum: " + maxValue);

        // c. Math.sqrt(x) → Returns square root
        double sqrtValue = Math.sqrt(25);
        System.out.println("Square root of 25: " + sqrtValue);

        // d. Math.pow(a, b) → Returns a raised to the power b
        double powValue = Math.pow(2, 3); // 2³
        System.out.println("2 to the power 3: " + powValue);

        // e. Math.avg() → No built-in method, calculate manually
        double num1 = 5, num2 = 15;
        double average = (num1 + num2) / 2;
        System.out.println("Average of 5 and 15: " + average);

        // f. Math.abs(x) → Returns absolute value
        int absValue = Math.abs(-42);
        System.out.println("Absolute value of -42: " + absValue);
    }
}
