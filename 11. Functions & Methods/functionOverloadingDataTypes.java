//! Function Overloading: Data Types - Java

public class functionOverloadingDataTypes {
    // func to calc int sum
    public static int Sum(int a, int b) {
        return a + b;
    }

    // func to calc float sum
    public static float Sum(float a, float b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(Sum(121, 212));
        System.out.println(Sum(23.2f, 32.21f));
    }
}
