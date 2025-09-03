//! Leap Year: Java

package assignments;

import java.util.Scanner;

public class leapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tLeap year or not?");

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            System.out.println("The year " + year + " is a leap year.");
        } else if (year % 100 == 0) {
            System.out.println("The year " + year + " is not a leap year.");
        } else if (year % 400 == 0) {
            System.out.println("The year " + year + " is a leap year.");
        } else {
            System.out.println("The year " + year + " is not a leap year.");
        }
    }
}
