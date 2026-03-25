// Problem Name: Merge Sort (Array)

public class MergeSort {

    // Merge function
    public static void merge(int arr[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];

        int i = left;      // left part
        int j = mid + 1;   // right part
        int k = 0;

        // compare and merge
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // remaining elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // copy back to original array
        for (k = 0, i = left; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Merge Sort function
    public static void mergeSort(int arr[], int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        // divide
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // conquer (merge)
        merge(arr, left, mid, right);
    }

    // Print array
    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Merge Sort Algorithm: Divide & Conquer Algorithm.");

        int arr[] = {5, 9, 1, 3, 8};

        System.out.print("Original: ");
        print(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted: ");
        print(arr);
    }
}
