// Taking user Inputs in Java:

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking a Floating user-input:
        System.out.print("Enter a floting value: ");
        float floting = scanner.nextFloat();
        System.out.println("You have entered: " + floting);

        // Taking a Integer user-input:
        System.out.print("Enter a Integer value: ");
        int integer = scanner.nextInt();
        System.out.println("You have entered: " + integer);

        // Taking a String user-input:
        System.out.print("\nEnter a String: ");
        String stringInput = scanner.next();
        System.out.println("You have entered: " + stringInput);

        // Taking a String user-input:
        System.out.print("\nEnter a String: ");
        String stringInput2 = scanner.nextLine();
        System.out.println("You have entered: " + stringInput2);

        scanner.close();
    }
}
