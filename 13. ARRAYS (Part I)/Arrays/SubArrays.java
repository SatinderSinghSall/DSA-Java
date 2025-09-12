// Print Subarrays:

package Arrays;

public class SubArrays {
    public static void PrintSubarray(int numbers[]) {
        int total_subarray = 0;
        for(int i = 0; i < numbers.length; i ++) {
            int start = i;
            for(int j = i + 1; j < numbers.length; j ++) {
                int end = j;
                for(int k = start; k <= end; k ++) {
                    System.out.print(numbers[k] + " ");
                }
                total_subarray ++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarray: " + total_subarray);
    }

    public static void main(String args[]) {
        int numbers[] = {2, 4, 6, 8, 10};

        PrintSubarray(numbers);
    }
}
