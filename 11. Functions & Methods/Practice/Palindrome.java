package Practice;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int result = num;
        int sum = 0;

        while(num > 0) {
            int rem = num % 10;
            sum = (sum * 10) + rem;
            num = num / 10;
        }

        if(result == sum) {
            System.out.println("The number " + result + " is palindrome.");
        } else {
            System.out.println("The number " + result + " is not palindrome.");
        }
    }
}
