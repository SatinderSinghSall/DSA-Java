// Merge Sort Algorithm:

public class MergeSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void Merge_Algorithm(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;      // iterator for left
        int j = mid + 1; // iterator for right
        int k = 0;       // iterator for temp

        // Merge left and right parts
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half (if any)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half (if any)
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp array back to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void MergeSort_Algorithm(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        // Recursive calls
        MergeSort_Algorithm(arr, si, mid);      // left part
        MergeSort_Algorithm(arr, mid + 1, ei);  // right part

        // Merge both halves
        Merge_Algorithm(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        MergeSort_Algorithm(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
