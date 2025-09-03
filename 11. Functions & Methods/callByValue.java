//! Call by Value: Java

public class callByValue {
    public static void swapNumbers(int a, int b) {
        // swap
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        // swap - values exchange
        int a = 5;
        int b = 10;
        System.out.println(a + " " + b);

        swapNumbers(a, b);
    }
}
