// Sorted and Rotated Array Search:

public class SearchInRotatedArray {
    public static int search(int arr[], int target, int si, int ei) {
        if (si > ei) {
            return -1; // base case: not found
        }

        int mid = si + (ei - si) / 2;

        // Case 1: target found
        if (arr[mid] == target) {
            return mid;
        }

        // Case 2: Left half is sorted
        if (arr[si] <= arr[mid]) {
            // Check if target lies within left sorted half
            if (target >= arr[si] && target < arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                return search(arr, target, mid + 1, ei);
            }
        }
        // Case 3: Right half is sorted
        else {
            if (target > arr[mid] && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            } else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(arr, target, 0, arr.length - 1);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in array.");
        }
    }
}
