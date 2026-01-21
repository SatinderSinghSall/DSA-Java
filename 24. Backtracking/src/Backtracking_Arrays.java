// Backtracking on Arrays:

public class Backtracking_Arrays {
    public static void printArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int index, int value) {
        // Base Case:
        if (index == arr.length) {
            printArray(arr);
            return;
        }

        // Recursion:
        arr[index] = value;
        changeArray(arr, index + 1, value + 1);
        arr[index] = arr[index] - 2;
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        int index = 0;
        int value = 1;

        changeArray(arr, index, value);
        printArray(arr);

    }
}
