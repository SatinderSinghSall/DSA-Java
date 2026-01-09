// Creating a 2D Array:

package Arrays_2D_Part_2;

import java.util.Scanner;

public class Creating_2D_Array {
    public static boolean SearchElement(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(matrix[i][j] == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length; // row
        int m = matrix[0].length; // cols
        int key = 10;

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

        boolean searchResult = SearchElement(matrix, key);

        if(searchResult == true) {
            System.out.println("Element " + key + " found.");
        } else {
            System.out.println("Element " + key + " not found.");
        }
    }
}
