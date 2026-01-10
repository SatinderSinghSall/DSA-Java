/*
    == Problem Statement: ==
    Print numbers in decreasing and increasing order
    from n to 1 and 1 to n.
*/

package Recursion;

public class PrintNumbers {
    public static void printNumberDescending(int num) {
        if(num == 1) { // base-case
            System.out.print(1);
            return;
        }
        System.out.print(num + " ");
        printNumberDescending(num - 1);
    }

    public static void printNumberIncreasing(int num) {
        if(num == 0) { // base-case
            return;
        }
        printNumberIncreasing(num - 1);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        int num = 10;

        printNumberDescending(num);
        System.out.println();
        printNumberIncreasing(num);
    }
}
