package Arrays_Tutorial_Offline;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
//        int number[] = new int[3];
//        System.out.println(number.length);
//
        int num[] = {2, 3, 4, 7, 32};
        for(int i = 0; i < num.length; i ++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        num[1] = 207;
        for(int i = 0; i < num.length; i ++) {
            System.out.print(num[i] + " ");
        }
        System.out.println(num.length);

//        int marks[] = new int[3];
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter your marks: ");
//        for(int i = 0; i < marks.length; i ++) {
//            marks[i] = sc.nextInt();
//        }
//
//        for(int i = 0; i < marks.length; i ++) {
//            System.out.print(marks[i] + " ");
//        }
    }
}
