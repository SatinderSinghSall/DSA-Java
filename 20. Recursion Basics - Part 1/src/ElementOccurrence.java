// Check an element occurrence first & last using Recursion:

public class ElementOccurrence {
    public static int FirstCheck_Logic(int arr[], int key, int index) {
        if (index == arr.length - 1) {
            return -1;
        }
        if (arr[index] == key) {
           return index;
       }
       return FirstCheck_Logic(arr, key, index + 1);
    }

    public static void LastCheck_Logic() {
        System.out.println("Testing...");
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        int key = 5;
        int index = 0;

        System.out.println(FirstCheck_Logic(arr, key, index));

//        LastCheck_Logic();
    }
}
