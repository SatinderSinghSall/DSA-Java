// Insertion Sort Algorithm:

package Sorting_Algorithms_Part_2;

public class InsertionSort {
    public static void InsertionSort_Algorithm(int numArr[]) {
        for(int i = 1; i < numArr.length; i ++) {
            int currEle = numArr[i]; // temp memory to store ele.
            int preEle = i - 1;

            // Finding out the correct position to insert:
            while(preEle >= 0 && numArr[preEle] > currEle) {
                numArr[preEle + 1] = numArr[preEle];
                preEle --;
            }

            // Insertion Algo:
            numArr[preEle + 1] = currEle;
        }
    }

    public static void PrintArray(int numbers[]) {
        for(int i = 0; i < numbers.length; i ++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        int numArr[] = {5, 4, 1, 3, 2};

        System.out.println("Array before Sorting:");
        PrintArray(numArr);

        InsertionSort_Algorithm(numArr);

        System.out.println();
        System.out.println("\nArray after Sorting:");
        PrintArray(numArr);
    }
}
