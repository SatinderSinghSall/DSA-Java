// Topic: Arithmetic Operators in Java:

import java.util.Scanner;

class ArithmeticOperators {
    public static void main(String[] args) {
        // ! Unary Operators: (++, and --)
        // int a = 10;
        // int b = ++a;
        // System.out.println(a);
        // System.out.println(b);

        int a = 10;
        int b = a++;
        System.out.println(a);
        System.out.println(b);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number 1: ");
        float A = scanner.nextFloat();

        System.out.print("Enter the number 2: ");
        float B = scanner.nextFloat();

        // ! Binary Operators: (+, -, *, /, and %)
        System.out.println("\nThe addition of: " + A + " + " + B + " = " + (A + B));
        System.out.println("The subtraction of: " + A + " - " + B + " = " + (A - B));
        System.out.println("The multiplication of: " + A + " * " + B + " = " + (A * B));
        System.out.println("The division of: " + A + " / " + B + " = " + (A / B));
        System.out.println("The modulus of: " + A + " % " + B + " = " + (A % B));

        scanner.close();
    }
}
