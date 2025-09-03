//! Pairs in an Array: Java

public class arrayPairs {
    public static void printArrayPairs(int numbers[]) {
        int totalPair = 0;
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[1]; // 2, 4, 6, 8, 10
            for (int j = 1 + i; j < numbers.length; j++) {
                System.out.print("(" + current + "," + numbers[j] + ") ");
                totalPair++;
            }
            System.out.println();
        }
        System.out.println("Total Pair: " + totalPair);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10 };
        printArrayPairs(numbers);
    }
}
