// Type Conversion in Java:

import java.util.Scanner;

public class TypeConversion {
    public static void main(String[] args) {
        // int a = 25;
        // long b = a;

        // long a = 25;
        // int b = a;
        // System.out.println(b);

        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter a number: ");
        // float number = scanner.nextFloat();
        // System.out.println("Number: " + number);

        // float a = 250.0f;
        // int b = (int)a;
        // System.out.println(b);

        // float a = 25.12f;
        // int b = (int) a; // lost .12
        // System.out.println(b);

        // char ch = 'S';
        // char ch2 = 'A';
        // int num = ch;
        // int num2 = ch2;

        // System.out.println(num);
        // System.out.println(num2);

        // ! Java Expressions:
        // char a = 'a';
        // char b = 'b';
        // char c = a - b;
        // System.out.println(c);
        // System.out.println((int) a);
        // System.out.println((int) b);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(b - a);

        // short a = 5;
        // byte b = 25;
        // char c = 'c';
        // byte bt = (byte) (a + b + c);
        // System.out.println(bt);

        int a = 10;
        float b = 20.25f;
        long c = 25;
        double d = 30;
        double ans = a + b + c + d;
        System.out.println(ans);
    }
}
