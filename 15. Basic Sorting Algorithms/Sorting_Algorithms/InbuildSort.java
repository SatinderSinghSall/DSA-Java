// Inbuild Sort Function:

package Sorting_Algorithms;

import java.util.Arrays;

public class InbuildSort {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 3, 2};

        System.out.println("\nArray before Sorting:");
        PrintArray(arr);

        Arrays.sort(arr);

        System.out.println("\nArray after Sorting:");
        PrintArray(arr);
    }
}
