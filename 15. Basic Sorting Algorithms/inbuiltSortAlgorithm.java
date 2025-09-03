//! Sorting: Inbuilt Sort Algorithm

import java.util.Arrays;
// import java.util.Collections;

public class inbuiltSortAlgorithm {
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

        System.out.println("\nSorted array:");
        // Arrays.sort(arr);
        Arrays.sort(arr, 0, 3);
        // Arrays.sort(arr, Collections.reverseOrder());
        printArray(arr);
    }
}
