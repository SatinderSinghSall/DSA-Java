// Reverse an Array:

package Arrays_Part_2;

public class ReverseArray {

    public static void ReverseArray_Logic(int numArr[]) {
        int first = 0;
        int last = numArr.length - 1;

        while (first < last) {
            // Swap the number: first & lase
            int temp = numArr[last];
            numArr[last] = numArr[first];
            numArr[first] = temp;

            first ++;
            last --;
        }
    }

    public static void main(String[] args) {
        int numArr[] = {1, 4, 6, 8, 10};

        ReverseArray_Logic(numArr);

        for(int i = 0; i < numArr.length; i ++) {
            System.out.println(numArr[i]);
        }
        System.out.println();
    }
}
