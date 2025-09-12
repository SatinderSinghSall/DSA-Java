// Pairs in an Array:

package Arrays;

public class PairsArray {
    public static void printArrayPairs(int numbers[]) {
        int total_pairs = 0;
        for(int i = 0; i < numbers.length; i ++) {
            int current_no = numbers[i];
            for(int j = i + 1; j < numbers.length; j ++) {
                System.out.print("[" + current_no + ", " + numbers[j] + "] ");
                total_pairs ++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs: " + total_pairs + "\n");
    }

    public static void main(String[] args) {
        System.out.println("\n===== Pairs in an Array: =====");
        int numbers[] = {2, 4, 6, 8, 10};
        System.out.print("Numbers Array: ");
        for(int i = 0; i < numbers.length; i ++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Pairs in Numbers Array: ");
        printArrayPairs(numbers);
    }
}
