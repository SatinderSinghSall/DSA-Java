// Pairs in Array:

package Arrays_Part_2.Arrays_Algorithms;

public class PairsArray {
    public static void PairsArray_Logic(int numbers[]) {
        for(int i = 0; i < numbers.length; i ++) {
            int curr = numbers[i]; // 2, 4, 6, 8, 10
            for(int j = i + 1; j < numbers.length; j ++) {
                System.out.print("(" + curr + "," + numbers[j] + ")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};

        PairsArray_Logic(numbers);
    }
}
