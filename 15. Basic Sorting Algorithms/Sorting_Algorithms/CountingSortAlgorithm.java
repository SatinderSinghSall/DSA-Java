// Counting Sort Algorithm:

package Sorting_Algorithms;

public class CountingSortAlgorithm {
    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void CountingSort_Algo(int arr[]) {
        int largestNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largestNum = Math.max(largestNum, arr[i]);
        }

        int count[] = new int[largestNum + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};

        System.out.println("\nCounting Sort Algorithm:");

        System.out.println("\nArray before Sorting:");
        PrintArray(arr);

        CountingSort_Algo(arr);

        System.out.println("\nArray after Sorting:");
        PrintArray(arr);
    }
}
