// Rotated Array Search Algorithm:

public class RotatedArraySearch {
    public static void PrintArray(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void RotatedArraySearch_Algorithm(int arr[]) {
        System.out.println("Testing...");
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};

        PrintArray(arr);
        RotatedArraySearch_Algorithm(arr);
        PrintArray(arr);
    }
}
