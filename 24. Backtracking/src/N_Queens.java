// N Queens Algorithm - All Ways:

public class N_Queens {
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

    public static void N_Queens_Algo(char chess_board[][], int row) {
        // Base Case:
        if (row == chess_board.length) {
            PrintBoard(chess_board);
            return;
        }

        // Column Loop:
        for (int i = 0; i < chess_board.length; i ++) {
            chess_board[row][i] = 'Q';
            N_Queens_Algo(chess_board, row + 1); // function call
            chess_board[row][i] = '.'; // backtracking step
        }
    }

    public static void main(String[] args) {
        int n = 2;
        char chess_board[][] = new char[n][n];
        int row = 0;

        // Initialize Chess Board:
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                chess_board[i][j] = '.';
            }
        }

        N_Queens_Algo(chess_board, row);
    }
}
