// Print largest string:

public class LargestString {
    public static void main(String[] args) {

        String[] arr = {"apple", "banana", "mango", "grapes"};

        String largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (largest.compareTo(arr[i]) < 0) {
                largest = arr[i];
            }
        }

        System.out.println("Largest string: " + largest);
    }
}
