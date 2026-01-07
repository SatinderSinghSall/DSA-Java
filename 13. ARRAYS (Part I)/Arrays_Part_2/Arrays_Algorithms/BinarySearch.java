// Binary Search Algorithm:

package Arrays_Part_2.Arrays_Algorithms;

public class BinarySearch {
    public static int BinarySearch_Algorithm(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Comparisons:
            if (numbers[mid] == key) { // found
                return mid;
            } if (numbers[mid] < key) { // right
                start = mid + 1;
            } else { // left
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 10;

        int index = BinarySearch_Algorithm(numbers, key);

        System.out.println("Found the key " + key + " at index: " + index);
    }
}
