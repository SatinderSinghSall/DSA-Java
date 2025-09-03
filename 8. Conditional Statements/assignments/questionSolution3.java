/*
 * Question - 3:
 * Write a Java program to input week number(1-7) and print day of week name using switch case.
*/

package assignments;

import java.util.Scanner;

public class questionSolution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a week number (1-7) : ");
        int weekNum = scanner.nextInt();

        switch (weekNum) {
            case 1:
                System.out.println("Today is Monday.");
                break;
            case 2:
                System.out.println("Today is Tuesday.");
                break;
            case 3:
                System.out.println("Today is Wednesday.");
                break;
            case 4:
                System.out.println("Today is Thursday.");
                break;
            case 5:
                System.out.println("Today is Friday.");
                break;
            case 6:
                System.out.println("Today is Saturday.");
                break;
            case 7:
                System.out.println("Today is Sunday.");
                break;
            default:
                System.out.println("Invalid Input, try again!");
                break;
        }
    }
}
