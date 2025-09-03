/*
 * Question:
 * > Keep entering numbers till user enters
 *   a multiple of 10.
*/

import java.util.Scanner;

public class breakQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\nEnter a number: ");
            int number = sc.nextInt();

            if (number % 10 == 0) {
                System.out.println("Number entered is " + number + ", which is divisible by 10.");
                System.out.println("do-while loop exiting...EXIT");
                break;
            }

            System.out.println("Number entered is: " + number);
        } while (true);
    }
}
