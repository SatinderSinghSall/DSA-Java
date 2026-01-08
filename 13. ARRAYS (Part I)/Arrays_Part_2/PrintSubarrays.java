// Printing Subarrays in a Array:

/*
    - A continuous part of array.
*/

package Arrays_Part_2;

public class PrintSubarrays {
    public static void  Subarray_Logic(int numArr[]) {
        int totalSubarrays = 0;
        for(int i = 0; i < numArr.length; i ++) {
            int start = i;
            for(int j = i; j < numArr.length; j ++) {
                int end = j;
                for(int k = start; k <= end; k ++) {
                    System.out.print(numArr[k]);
                }
                System.out.println();
                totalSubarrays = totalSubarrays + 1;
            }
        }
        System.out.println();
        System.out.println(totalSubarrays);
    }

    public static void main(String[] args) {
        int numArr[] = {2, 4, 6, 8, 10};

        Subarray_Logic(numArr);
    }
}
