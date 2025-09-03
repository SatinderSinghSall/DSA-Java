//! Switch: Java

import java.util.Scanner;

class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.print("Samosa");
                break;
            case 2:
                System.out.print("Burger");
                break;
            case 3:
                System.out.print("Mango Shake");
                break;
            default:
                System.out.println("We realize we are dreaming...");
                break;
        }
    }
}