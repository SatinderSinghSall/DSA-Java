// Search in Sorted Matrix:

package Arrays_2D;

public class Search_in_Sorted_Matrix {

    public static boolean searchInSortedMatrix(int[][] matrix, int key) {
        int row = 0;
        int col = matrix[0].length - 1;  // start from top-right

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("\nElement found at position (" + row + ", " + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--; // move left
            } else {
                row++; // move down
            }
        }

        System.out.println("\nElement NOT found in the matrix.");
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        int key = 37;

        System.out.println("\nMatrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        searchInSortedMatrix(matrix, key);
    }
}
