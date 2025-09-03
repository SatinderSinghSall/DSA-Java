// Zero One Triangle:

package Patterns;

public class ZeroOneTriangle {
    public static void Print_ZeroOne(int num) {
        for(int i = 1; i <= num; i ++) {
            for(int j = 1; j <= i; j ++) {
                if((i + j) % 2 == 0) {
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_ZeroOne(5);
    }
}
