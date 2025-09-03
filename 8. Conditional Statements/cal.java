import java.util.Scanner;

public class cal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("\nEnter the first number: ");
            float number1 = scanner.nextFloat();

            System.out.print("Enter the second number: ");
            float number2 = scanner.nextFloat();

            System.out.print("\nOperation: +, -, *, /, %");
            System.out.print("\nSelect your operation: ");
            char operator = scanner.next().charAt(0);

            float result = 0;
            boolean validOperation = true;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 == 0) {
                        System.out.println("\n\tError: Cannot divide by zero.");
                        validOperation = false;
                    } else {
                        result = number1 / number2;
                    }
                    break;
                case '%':
                    result = number1 % number2;
                    break;
                default:
                    System.out.println("\n\tError: Invalid operator. Please choose from +, -, *, /, %.");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("\nResult: " + number1 + " " + operator + " " + number2 + " = " + result);
            }
        } catch (Exception e) {
            System.out.println("\n\tInput Error: Please enter valid numbers and operations.");
        } finally {
            scanner.close();
        }
    }
}
