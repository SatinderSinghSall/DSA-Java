/*
 * Question:
 * > Display all numbers entered by user except
 *   multiples of 10.
*/

import java.util.Scanner;

public class continueQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\nEnter a number: ");
            int num = sc.nextInt();

            if (num % 10 == 0) {
                continue;
            } else {
                System.out.println("Number is: " + num);
            }
        } while (true);
    }
}
