// Backtracking on Arrays:

public class Backtracking_Arrays {
    public static void printArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int index, int value) {
        System.out.println("Testing...");
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        int index = 0;
        int value = 1;

        changeArray(arr, index, value);
        printArray(arr);

    }
}
