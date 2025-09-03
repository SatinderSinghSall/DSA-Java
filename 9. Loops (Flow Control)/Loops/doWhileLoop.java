package Loops;

import java.util.Scanner;

public class doWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            if (num % 10 == 0) {
                System.out.println("Exiting the code...");
                break;
            }
        } while (true);

    }
}
