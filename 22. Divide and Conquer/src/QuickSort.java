// Quick Sort Algorithm:

public class QuickSort {
    // Utility function to print array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Partition function
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // Choose last element as pivot
        int i = si - 1;      // Place for swapping smaller elements

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at its correct position
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;

        return i; // return pivot index
    }

    // Recursive Quick Sort function
    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        // Partition index
        int pIdx = partition(arr, si, ei);

        // Recursively sort left and right subarrays
        quickSort(arr, si, pIdx - 1); // left
        quickSort(arr, pIdx + 1, ei); // right
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
