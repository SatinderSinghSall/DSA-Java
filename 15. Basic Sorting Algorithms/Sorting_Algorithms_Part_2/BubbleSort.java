// Bubble Sort Algorithm:

package Sorting_Algorithms_Part_2;

public class BubbleSort {
    public static void BubbleSort_Algorithm(int numbers[]) {
        for(int i = 0; i < numbers.length - 1; i ++) {
            for(int j = 0; j < numbers.length - 1; j ++) {
                if(numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
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

        BubbleSort_Algorithm(numbers);

        System.out.println();
        System.out.println("\nArray after Sorting:");
        PrintArray(numbers);
    }
}
