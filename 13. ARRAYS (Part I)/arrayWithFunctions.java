//! Passing arrays as an argument: Java

public class arrayWithFunctions {
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        int marks[] = { 97, 98, 99 };

        // Printing marks: Before
        System.out.println("\nPrinting marks: Before");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();

        update(marks);

        // Printing marks: After
        System.out.println("\nPrinting marks: After");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
}
