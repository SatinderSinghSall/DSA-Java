// Selection Sort Algorithm:

package Sorting_Algorithms_Part_2;

public class SelectionSort {
    public static void SelectionSort_Algorithm(int numbers[]) {
        System.out.println("Testing...");
    }

    public static void PrintArray(int numbers[]) {
        for(int i = 0; i < numbers.length; i ++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        int numbers[] = {5, 4, 1, 3, 2};

        System.out.println("Array before Sorting:");
        PrintArray(numbers);

        SelectionSort_Algorithm(numbers);

        System.out.println();
        System.out.println("\nArray after Sorting:");
        PrintArray(numbers);
    }
}
