// Creating a 2D Array:

package Arrays_2D_Part_2;

import java.util.Scanner;

public class Creating_2D_Array {
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length; // row
        int m = matrix[0].length; // cols

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter data for matrix " + n + " x " + m + ": ");
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nArray is:");
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
