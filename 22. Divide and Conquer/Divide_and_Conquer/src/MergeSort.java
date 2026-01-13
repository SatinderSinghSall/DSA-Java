// Merge Sort Algorithm:

public class MergeSort {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int MergeSort_Algorithm(int arr[], int si, int ei) {
        System.out.println("Testing...");
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 9, 5, 2, 8};
        int si = arr[0];
        int ei = arr.length - 1;

        PrintArray(arr);
        MergeSort_Algorithm(arr, si, ei);
        PrintArray(arr);
    }
}
