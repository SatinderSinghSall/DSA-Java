package Arrays;

import java.util.Scanner;

public class JavaArrays {
    public static void updateNumbers(int numbers[]) {
        for(int i = 0; i < numbers.length; i ++) {
            numbers[i] = numbers[i] + 1;
        }
    }

    public static void main(String[] args) {
        // Arrays: Creation of an Aray:
        int marks[] = new int[50];
        int numbers_[] = {1, 2, 3};
        int moreNumbers[] = {4, 5, 6};
        String friuts[] = {"Apple", "Mango", "Orange"};

        // Arrays: Input, Output & Update:
        int marks_2[] = new int[100];

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the Physics marks: ");
        marks_2[0] = scanner.nextInt();

        System.out.print("Enter the Chemistry marks: ");
        marks_2[1] = scanner.nextInt();

        System.out.print("Enter the Mathematics marks: ");
        marks_2[2] = scanner.nextInt();

        System.out.println("\nPhysics Marks: " + marks_2[0]);
        System.out.println("Chemistry Marks: " + marks_2[1]);
        System.out.println("Mathematics Marks: " + marks_2[2]);

        marks_2[2] = 100;
        System.out.println("UPDATED: Mathematics Marks: " + marks_2[2]);

        int percentage = (marks_2[0] + marks_2[1] + marks_2[2]) / 3;
        System.out.println("\nPERCENTAGE is: " + percentage + " %");

        System.out.println("Length of marks_2 array is: " + marks_2.length);

        // Passing arrays as arguments:
        int numbers[] = {97, 98, 99};
        updateNumbers(numbers);

        for(int i = 0; i <= numbers.length; i ++) {
            System.out.println(numbers[i]);
        }
    }
}
