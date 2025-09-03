package Loops;

import java.util.Scanner;

public class whileLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        int sum = 0;
        int counter = 1;

        while(counter <= num) {
            sum = sum + counter;
            counter ++;
        }
        System.out.println(sum);
    }
}
