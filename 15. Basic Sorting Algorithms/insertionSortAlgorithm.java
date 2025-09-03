//! Sorting: Insertion Sort Algorithm

public class insertionSortAlgorithm {
    public static void InsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int currEle = arr[i];
            int prevEle = i - 1;
            // finding the correct position t insert
            while (prevEle >= 0 && arr[prevEle] > currEle) {
                arr[prevEle + 1] = arr[prevEle];
                prevEle--;
            }
            // insertion
            arr[prevEle + 1] = currEle;
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };

        System.out.println("\nArray before sort algo:");
        printArray(arr);

        InsertionSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}
