package My_Practice;

public class LinearSearch_2 {
    public static int linearSearch(int numbers[], int key) {
        for(int i = 0; i < numbers.length; i ++) {
            if(numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 2;

        int result = linearSearch(numbers, key);

        for(int i = 0; i < numbers.length; i ++) {
            System.out.print(numbers[i] + " ");
        }

        if(result == -1) {
            System.out.println("\nThe key " + key + " NOT found.");
        } else {
            System.out.println("\nThe key " + key + " found in index " + result);
        }
    }
}
