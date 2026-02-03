// N Queens Algorithm - One Solution:

public class N_Queens_OneSolution {
    public static void PrintBoard(char chess_board[][]) {
        int n = chess_board.length;

        // Column labels
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // Top border
        System.out.print("  ┌");
        for (int i = 0; i < n; i++) {
            System.out.print("───");
            if (i < n - 1) System.out.print("┬");
        }
        System.out.println("┐");

        // Board rows
        for (int i = 0; i < n; i++) {
            System.out.print(i + " │");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + chess_board[i][j] + " │");
            }
            System.out.println();

            // Middle border
            if (i < n - 1) {
                System.out.print("  ├");
                for (int j = 0; j < n; j++) {
                    System.out.print("───");
                    if (j < n - 1) System.out.print("┼");
                }
                System.out.println("┤");
            }
        }

        // Bottom border
        System.out.print("  └");
        for (int i = 0; i < n; i++) {
            System.out.print("───");
            if (i < n - 1) System.out.print("┴");
        }
        System.out.println("┘\n");
    }

    public static boolean isSafe(char chess_board[][], int row, int col) {
        // Vertical Up:
        for (int i = row - 1; i >= 0; i --) {
            if (chess_board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal Left Up:
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i --, j --) {
            if (chess_board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal Right Up:
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess_board.length; i --, j ++) {
            if (chess_board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static boolean N_Queens_Algo(char chess_board[][], int row) {
        // Base Case:
        if (row == chess_board.length) {
            totalWays++;
            System.out.println("Solution #" + totalWays);
            PrintBoard(chess_board);
            return true;
        }

        // Column Loop:
        for (int i = 0; i < chess_board.length; i ++) {
            if (isSafe(chess_board, row, i)) {
                chess_board[row][i] = 'Q';
                if(N_Queens_Algo(chess_board, row + 1)) { // function call
                    return true;
                }
                chess_board[row][i] = '.'; // backtracking step
            }
        }
        return false;
    }

    static int totalWays = 0;
    public static void main(String[] args) {
        System.out.println("\nN Queens Algorithm - All Ways:\n");

        int n = 4;
        char chess_board[][] = new char[n][n];
        int row = 0;

        // Initialize Chess Board:
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                chess_board[i][j] = '.';
            }
        }

        if (N_Queens_Algo(chess_board, row)) { // TC = O(n!))
            System.out.println("Solution is POSSIBLE.");
            // PrintBoard(chess_board);
        } else {
            System.out.println("Solution is NOT possible.");
        }
        System.out.println("Total ways = " + totalWays);
    }
}
