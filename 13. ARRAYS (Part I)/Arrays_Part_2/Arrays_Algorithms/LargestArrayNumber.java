// Find the Largest Array Number Algorithm:

package Arrays_Part_2.Arrays_Algorithms;

public class LargestArrayNumber {
    public static int LargestArrayNumber_Algorithm(int numbers[]) {
        int maxNumber = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i ++) {
            if(numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        int numbers[] = {11, 2, 3, 5, 23, 180};
        int result = LargestArrayNumber_Algorithm(numbers);
        System.out.println(result);
    }
}
