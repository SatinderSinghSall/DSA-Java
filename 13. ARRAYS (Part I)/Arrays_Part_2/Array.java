package Arrays_Part_2;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        // Array Creation:
        int marks[] = new int[50];
        System.out.println("Array length: " + marks.length);
        int numbers[] = {1, 2, 3};
        int moreNumbers[] = {4, 5, 6};
        String fruts[] = {"Apple", "Mango", "Orange"};

        // Array Input / Output:
        int arrMarks[] = new int[100];
        Scanner sc = new Scanner(System.in);
//        int phyics;
//        phy = sc.nextInt();

        System.out.print("Enter Physics marks: ");
        arrMarks[0] = sc.nextInt(); // phy

        System.out.print("Enter Chemistry marks: ");
        arrMarks[1] = sc.nextInt(); // che

        System.out.print("Enter Mathematics marks: ");
        arrMarks[2] = sc.nextInt(); // mat

        System.out.println("Marks of Physics: " + arrMarks[0]);
        System.out.println("Marks of Chemistry: " + arrMarks[1]);
        System.out.println("Marks of Mathematics: " + arrMarks[2]);

        arrMarks[2] = 100;
        System.out.println("Marks of Mathematics: " + arrMarks[2]);
    }
}
