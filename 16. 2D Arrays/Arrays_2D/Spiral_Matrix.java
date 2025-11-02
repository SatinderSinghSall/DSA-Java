// Spiral Matrix:

package Arrays_2D;

public class Spiral_Matrix {

    public static void Print_SpiralMatrix(int[][] matrix) {
        int startRow = 0;
        int startColumn = 0;
        int endRow = matrix.length - 1;
        int endColumn = matrix[0].length - 1;

        System.out.println("\nSpiral Matrix Traversal:");

        while (startRow <= endRow && startColumn <= endColumn) {

            // 1️⃣ Top boundary (left → right)
            for (int j = startColumn; j <= endColumn; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // 2️⃣ Right boundary (top → bottom)
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endColumn] + " ");
            }

            // 3️⃣ Bottom boundary (right → left)
            if (startRow < endRow) {
                for (int j = endColumn - 1; j >= startColumn; j--) {
                    System.out.print(matrix[endRow][j] + " ");
                }
            }

            // 4️⃣ Left boundary (bottom → top)
            if (startColumn < endColumn) {
                for (int i = endRow - 1; i > startRow; i--) {
                    System.out.print(matrix[i][startColumn] + " ");
                }
            }

            // Move towards the inner spiral
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        Print_SpiralMatrix(matrix);
    }
}
