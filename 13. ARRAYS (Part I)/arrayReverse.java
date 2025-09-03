//! Reverse an Array: Java

public class arrayReverse {
    public static void ReverseArray(int numbers[]) {
        int first = 0;
        int last = numbers.length - 1;

        while (first < last) {
            // swap:
            int temp = numbers[last];
            numbers[last] = first;
            numbers[first] = temp;
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int numbres[] = { 2, 4, 6, 8, 10 };

        System.out.println("\nArray before swapping:");
        for (int i = 0; i < numbres.length; i++) {
            System.out.print(numbres[i] + " ");
        }
        System.out.println();

        // method call:
        ReverseArray(numbres);

        System.out.println("\nArray after swapping:");
        for (int i = 0; i < numbres.length; i++) {
            System.out.print(numbres[i] + " ");
        }
        System.out.println();
    }
}
