//! Largest number in the given array:

public class largestNumberArray {
    public static int LargestNumber(int numbers[]) {
        int largestNumber = Integer.MIN_VALUE; // -infinity
        int smallestNumber = Integer.MAX_VALUE; // +infinity

        for (int i = 0; i < numbers.length; i++) {
            if (largestNumber < numbers[i]) {
                largestNumber = numbers[i];
            }
            if (smallestNumber > numbers[i]) {
                smallestNumber = numbers[i];
            }
        }

        System.out.println("\nThe smallest value is: " + smallestNumber);
        return largestNumber;
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 2, 6, 3, 5 };

        System.out.println("Largest value is: " + LargestNumber(numbers));
    }
}
