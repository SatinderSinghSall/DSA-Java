// Quick Sort Algorithm:

public class QuickSort {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void QuickSort_Algorithm(int arr[], int si, int ei) {
        System.out.println("Testing...");
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        int si = 0;
        int ei = arr.length;

        PrintArray(arr);
        QuickSort_Algorithm(arr, si, ei);
        PrintArray(arr);
    }
}
