// Selection Sort Algorithm:

package Sorting_Algorithms;

public class SelectionSortAlgorithm {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void SelectionSort_Algo(int arr[]) {
        for(int i = 0;  i < arr.length - 1; i ++) {
            int minPos = i;
            for(int j = i + 1; j < arr.length; j ++) {
                if(arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("\nSelection Sort Algorithm:");

        int arr[] = {5, 4, 1, 3, 2};

        System.out.println("\nArray before Sorting:");
        PrintArray(arr);

        SelectionSort_Algo(arr);

        System.out.println("\nArray after Sorting:");
        PrintArray(arr);
    }
}
