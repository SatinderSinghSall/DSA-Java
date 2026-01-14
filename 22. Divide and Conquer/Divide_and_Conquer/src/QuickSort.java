// Quick Sort Algorithm:

public class QuickSort {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j ++) {
            if (arr[j] <= pivot) {
                i ++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i ++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void QuickSort_Algorithm(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int p_index = partition(arr, si, ei); // last element
        QuickSort_Algorithm(arr, si, p_index - 1); // left part
        QuickSort_Algorithm(arr, p_index + 1, ei); // right part
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        int si = 0;
        int ei = arr.length - 1;

        PrintArray(arr);
        QuickSort_Algorithm(arr, si, ei);
        PrintArray(arr);
    }
}
