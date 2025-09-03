// Largest Number in a given Array:

package Arrays;

public class LargestNumberArray {
    public static int largestNumber(int numnbers[]) {
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < numnbers.length; i ++) {
            if(numnbers[i] > largest) {
                largest = numnbers[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int numbers[] = {1, 2, 6, 3, 5, 20, 11, 12};
        int result = largestNumber(numbers);
        System.out.println(result);
    }
}
