// Selection Sort Algorithm:

package Sorting_Algorithms_Part_2;

public class SelectionSort {
    public static void SelectionSort_Algorithm(int numbers[]) {
        for(int i =0; i < numbers.length - 1; i ++) {
            int minPos = i;
            for(int j = i + 1; j < numbers.length; j ++) {
                if(numbers[minPos] > numbers[j]) {
                    minPos = j;
                }
            }
            int temp = numbers[minPos];
            numbers[minPos] = numbers[i];
            numbers[i] = temp;
        }
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
