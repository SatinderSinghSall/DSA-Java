package Practice;

public class SumOfDigits {
    // Method to compute sum of digits
    public static int sumDigits(int number) {
        int sum = 0;

        // Make sure to work with positive numbers
        number = Math.abs(number);

        while (number > 0) {
            int lastDigit = number % 10; // Get last digit
            sum += lastDigit;            // Add to sum
            number /= 10;                 // Remove last digit
        }

        return sum;
    }

    public static void main(String[] args) {
        int num = 12345; // Example input
        int result = sumDigits(num);
        System.out.println("Sum of digits in " + num + " is: " + result);
    }
}
