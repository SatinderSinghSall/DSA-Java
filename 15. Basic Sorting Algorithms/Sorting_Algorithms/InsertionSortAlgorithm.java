// Insertion Sort Algorithm:

package Sorting_Algorithms;

public class InsertionSortAlgorithm {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void InsertionSort_Algo(int arr[]) {
        for(int i = 1; i < arr.length; i ++) {
            int currEle = arr[i];
            int pevEle = i - 1;
            // Finding out the correct position to Insert:
            while (pevEle >= 0 && arr[pevEle] > currEle) {
                arr[pevEle + 1] = arr[pevEle];
                pevEle --;
            }

            // Inserting an Element:
            arr[pevEle + 1] = currEle;
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 3, 2};

        System.out.println("\nArray before Sorting:");
        PrintArray(arr);

        InsertionSort_Algo(arr);

        System.out.println("\nArray after Sorting:");
        PrintArray(arr);
    }
}
