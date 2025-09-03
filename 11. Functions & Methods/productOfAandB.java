//! Find product of a & b: Java

public class productOfAandB {
    public static int product(int a, int b) {
        int res = a * b;
        return res;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 10;

        int res = product(a, b);
        System.out.println("The product of: " + a + " * " + b + " = " + res);
    }
}
