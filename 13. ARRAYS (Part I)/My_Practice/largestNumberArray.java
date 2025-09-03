//! Largest number in the given array:

package My_Practice;

public class largestNumberArray {
    public static int LargestNumber(int numbers[]) {
        int largestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largestNumber < numbers[i]) {
                largestNumber = numbers[i];
            }
        }

        return largestNumber;
    }

    public static void main(String[] args) {
        int numbers[] = { 10, 20, 34, 2, 23, 24 };

        System.out.println("\nThe array elements are:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int largestNumber = LargestNumber(numbers);

        System.out.println("\nThe largest number is: " + largestNumber);
    }
}
