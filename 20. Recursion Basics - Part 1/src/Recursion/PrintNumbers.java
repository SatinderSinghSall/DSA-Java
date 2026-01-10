/*
    == Problem Statement: ==
    Print numbers in decreasing and increasing order
    from n to 1 and 1 to n.
*/

package Recursion;

public class PrintNumbers {
    public static void printNumberDescending(int num) {
        if(num == 1) { // base-case
            System.out.println(1);
            return;
        }
        System.out.print(num + " ");
        printNumberDescending(num - 1);
    }

    public static void main(String[] args) {
        int num = 10;

        printNumberDescending(num);
    }
}
