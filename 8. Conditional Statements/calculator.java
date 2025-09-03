//! Calculator: Java

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the first number: ");
        float number1 = scanner.nextFloat();

        System.out.print("Enter the second number: ");
        float number2 = scanner.nextFloat();

        System.out.print("\nOperation: +, -, /, % and * | ");
        System.out.print("Select your operation: ");
        char operator = scanner.next().charAt(0);

        float result = 0;
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
                    System.out.println("\tError: Can not divide by Zero.");
                } else {
                    result = number1 / number2;
                    break;
                }
            case '%':
                result = number1 % number2;
                break;
            default:
                System.out.println("\n\tOperator Error: Invalid Operator Operation Selection.");
                break;
        }

        System.out.println("\nResult: " + number1 + " " + operator + " " + number2 + " = " + result);
    }
}
