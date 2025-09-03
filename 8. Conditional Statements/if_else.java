//! if-else statements in Java:

import java.util.Scanner;

class if_else {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your age: ");
        int userAge = scanner.nextInt();

        if (userAge >= 18) {
            System.out.println("\nYou can: Vote, Drive and an Adult.");
        }
        if (userAge >= 13 && userAge < 18) {
            System.out.println("\nYou are: Teenager.");
        } else {
            System.out.println("\nYou are not an Adult, Yet!");
            System.out.println("Try after: " + (18 - userAge) + " years.");
        }
    }
}
