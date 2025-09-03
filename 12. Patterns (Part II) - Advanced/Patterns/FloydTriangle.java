// Floyd's Triangle:

package Patterns;

public class FloydTriangle {
    public static void Print_FloydTriangle(int num, int coun) {
        for(int i = 1; i <= num; i ++) {
            for(int j = 1; j <= i; j ++) {
                System.out.print(j + " ");
                coun ++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Print_FloydTriangle(5, 1);
    }
}
