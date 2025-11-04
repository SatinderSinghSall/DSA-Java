// String in Java:

import java.util.Scanner;

public class JavaString {
    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "a b c d";
        String str2 = new String("x y z");
        // Strings are immutable in Java.

        // Strings - Input & Output:
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String userInput = scanner.nextLine();

        System.out.println("\nUser Prompt: " + userInput);

        // String - length()
        String fullName = "Satinder Singh Sall";
        System.out.println(fullName.length());

        // String Concatenation:
        String firstName = "Satinder";
        String middleName = "Singh";
        String lastName = "Sall";
        String fullName2 = firstName + " " + middleName + " " + lastName;
        System.out.println("Full Name: " + fullName2);
    }
}
