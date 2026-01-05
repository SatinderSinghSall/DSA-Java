// Arrays as Functions Arguments:

package Arrays_Part_2;

public class Arrays_Functions {
    public static void updateNumber(int marks[]) {
        for(int i = 0; i < marks.length; i ++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        int marks[] = {97, 98, 99};

        System.out.println("Marks Before Update:");
        for(int i = 0; i < marks.length; i ++) {
            System.out.println("Marks: " + marks[i]);
        }

        updateNumber(marks);

        System.out.println("\nMarks After Update:");
        for(int i = 0; i < marks.length; i ++) {
            System.out.println("Marks: " + marks[i]);
        }
        System.out.println();
    }
}
