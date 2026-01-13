// Merge Sort Algorithm:

public class MergeSort {

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void MergeAlgo(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;       // left subarray pointer
        int j = mid + 1;  // right subarray pointer
        int k = 0;        // temp array pointer

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void MergeSort_Algorithm(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        MergeSort_Algorithm(arr, si, mid);       // left part
        MergeSort_Algorithm(arr, mid + 1, ei);   // right part
        MergeAlgo(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 9, 5, 2, 8};
        int si = 0;
        int ei = arr.length - 1;

        PrintArray(arr);
        MergeSort_Algorithm(arr, si, ei);
        PrintArray(arr);
    }
}
