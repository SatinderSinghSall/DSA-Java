//! else-if: Java

import java.util.Scanner;

public class elseif {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();

        if (userAge >= 18) {
            System.out.println("Dear, " + userName + " you are an Adult.");
        } else if (userAge >= 13 && userAge < 18) {
            System.out.println("Dear, " + userName + " you are a Teenager.");
        } else {
            System.out.println("Dear, " + userName + " you are an Child.");
        }
    }
}
