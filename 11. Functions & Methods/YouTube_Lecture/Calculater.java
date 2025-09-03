package YouTube_Lecture;

public class Calculater {
    // Addition: Sum: 5 + 5 = 10
    public static void addNumber(int num1, int num2) {
        int sumResult = num1 + num2;
        System.out.println("Sum: " + num1 + " + " + num2 + " = " + sumResult);
    }

    // Subtraction: Sum: 5 - 5 = 0
    public static void subNumber(int num1, int num2) {
        int subResult = num1 - num2;
        System.out.println("Sub: " + num1 + " - " + num2 + " = " + subResult);
    }

    // Multiplication: Sum: 5 * 5 = 25
    public static void mulNumber(int num1, int num2) {
        int mulResult = num1 * num2;
        System.out.println("Sub: " + num1 + " * " + num2 + " = " + mulResult);
    }

    public static void main(String[] args) {
        addNumber(5, 5);
        subNumber(5, 1);
        mulNumber(5, 5);
    }
}
