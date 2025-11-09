// Square Pattern - Java:

public class SquarePattern_V {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;

        for(int i = 1; i <= rows; i ++) {
            for(int j = 1; j <= columns; j ++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
