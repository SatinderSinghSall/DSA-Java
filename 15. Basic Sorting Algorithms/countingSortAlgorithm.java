//! Sorting: Counting Sort Algorithm

public class countingSortAlgorithm {
    public static void countingSort(int arr[]) {

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 1, 3, 2, 4, 3, 7 };

        System.out.println("\nArray before sort algo:");
        printArray(arr);

        countingSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}
