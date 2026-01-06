// Linear Search Algorithm:

package Arrays_Part_2.Arrays_Algorithms;

public class LinearSearch {
    public static void LinearSearch_Algorithm(int numbers[], int key) {
        boolean found = false;
        for(int i = 0; i < numbers.length; i ++) {
            if(numbers[i] == key) {
                System.out.println("Element " + key + " found at index: " + i);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Key NOT found.");
        }
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 10;

        LinearSearch_Algorithm(numbers, key);
    }
}
