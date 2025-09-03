//! Function Overloading: Java

public class functionOverloading {
    // func to calc sum of 2 nums
    public static int Sum(int a, int b) {
        return a + b;
    }

    // func to calc sum of 3 nums
    public static int Sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(Sum(1, 2));
        System.out.println(Sum(1, 3, 5));
    }
}
