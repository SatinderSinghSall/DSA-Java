/*
    == Problem Statement: ==
    Find factorial of n.
*/

package Recursion;

public class Factorial {
    public static int Factorial_Logic(int num) {
        if(num == 0) {
            return 1;
        }
        int fnm1 = Factorial_Logic(num - 1);
        int fn = num * Factorial_Logic(num - 1);
        return fn;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(Factorial_Logic(num));
    }
}
