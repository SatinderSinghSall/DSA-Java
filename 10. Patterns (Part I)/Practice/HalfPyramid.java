package Practice;

public class HalfPyramid {
    public static void main(String[] args) {
        int num = 4;
        // Outer Loop:
        for(int i = 1; i <= num; i ++) {
            // Inner Loop:
            for(int j = 1; j <= i; j ++) {
                System.out.print(j + " ");
            }
            // New Line:
            System.out.println();
        }
    }
}
