//! Printing STAR pattern numbers: Java

public class squarePattern2 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        int num = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
