/*
 * Question:
 * while Loop: Numbers from 1 to n: Java
*/

import java.util.Scanner;

public class whileLoopPrint2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the 'n' number: ");
        int number_n = scanner.nextInt();

        int counter = 1;
        while (counter <= number_n) {
            System.out.println("Number: " + counter);
            counter++;
        }
    }
}
