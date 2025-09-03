//! Algorithm: Linear Search

package My_Practice;

public class linearSearchAlgorithm {
    public static int LinearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 3, 5, 77 };
        int key = 77;
        int index = LinearSearch(numbers, key);

        if (index == -1) {
            System.out.println("\nThe key NOT found.");
        } else {
            System.out.println("\nThe key " + key + " is FOUND at index: " + index);
        }
    }
}
