// Insertion Sort Algorithm:

package Sorting_Algorithms_Part_2;

public class InsertionSort {
    public static void InsertionSort_Algorithm(int numArr[]) {
        System.out.println("Teating...");
    }

    public static void PrintArray(int numbers[]) {
        for(int i = 0; i < numbers.length; i ++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        int numArr[] = {5, 4, 1, 3, 2};

        System.out.println("Array before Sorting:");
        PrintArray(numArr);

        InsertionSort_Algorithm(numArr);

        System.out.println();
        System.out.println("\nArray after Sorting:");
        PrintArray(numArr);
    }
}
