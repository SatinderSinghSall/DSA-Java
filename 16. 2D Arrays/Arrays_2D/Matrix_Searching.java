// Java 2D Arrays Search Function:

package Arrays_2D;

import java.util.Scanner;

public class Matrix_Searching {
    public static boolean SearchingAlgorithm(int matrix[][], int rows, int columns, int key) {
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                if(matrix[i][j] == key) {
                    System.out.println("\nElement " + key + " found at cell (" + i + ", " + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Element NOT found.");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("\n\tJava 2-D Arrays Search Operation:");
        Scanner scanner = new Scanner(System.in);

        int matrix[][] = new int[3][3];
        int rows = matrix.length;
        int columns = matrix[0].length;
        int key = 9;

        //User Input:
        System.out.println("\nEnter the 3 * 3 matrix: ");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Output:
        System.out.println("\nOutput:");
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        SearchingAlgorithm(matrix, rows, columns, key);
    }
}
