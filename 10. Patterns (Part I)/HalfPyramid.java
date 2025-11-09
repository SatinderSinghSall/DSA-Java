public class HalfPyramid {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        for(int i = 1; i <= columns; i ++) {
            for(int j = 1; j <= i; j ++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
