// Check if an array is sorted in ascending order using recursion

public class CheckSortedArray {
    // Recursive function to check if array is sorted
    public static boolean isSorted(int[] arr, int index) {
        // Base case: if we reach the last element, it's sorted
        if (index == arr.length - 1) {
            return true;
        }

        // If the current element is greater than the next, it's not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Recursive call to check the rest of the array
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};  // Try {1, 3, 2, 4} to test unsorted case

        boolean result = isSorted(arr, 0);

        if (result)
            System.out.println("The array is sorted.");
        else
            System.out.println("The array is NOT sorted.");
    }
}
