/*
 * Practice Question - 5 :
 * Write a Java program that takes a year from the user and print whether that year is a leap year or not.
*/

package assignments;

import java.util.Scanner;

public class questionSolution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tLeap year or not?");

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("The year " + year + " is a leap year.");
                } else {
                    System.out.println("The year " + year + " is not a leap year.");
                }
            } else {
                System.out.println("The year " + year + " is a leap year.");
            }
        } else {
            System.out.println("The year " + year + " is not a leap year.");
        }
    }
}
