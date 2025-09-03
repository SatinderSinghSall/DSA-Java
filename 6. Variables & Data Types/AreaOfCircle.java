// Area of circle in Java:

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of radius: ");
        float radius = scanner.nextFloat();
        float PI = 3.14f;
        float area = PI * radius * radius;
        System.out.println(area);
    }
}
