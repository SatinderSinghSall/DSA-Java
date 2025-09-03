//! Income Tax Calculator: Java

import java.util.Scanner;

public class incomeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your income: ");
        int userIncome = scanner.nextInt();

        String tax;
        if (userIncome < 5) {
            tax = "0%";
        } else if (userIncome >= 5 && userIncome <= 10) {
            tax = "10%";
        } else {
            tax = "30%";
        }

        System.out.println("Dear, " + userName + ". According to your income you have " + tax + " tax.");
    }
}
