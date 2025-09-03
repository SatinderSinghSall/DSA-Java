// Product of 2 nums:

import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number 1: ");
        float num1 = scanner.nextFloat();

        System.out.print("Enter the number 2: ");
        float num2 = scanner.nextFloat();

        float prd = num1 * num2;

        System.out.println(prd);
    }
}
