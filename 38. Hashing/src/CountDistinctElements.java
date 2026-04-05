// Hashing: Count Distinct Elements.

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        System.out.println("Hashing: Count Distinct Elements.");

        int[] arr = {10, 20, 20, 30, 40, 10, 50};

        HashSet<Integer> set = new HashSet<>();

        System.out.println();
        for (int ele : arr) {
            System.out.print(ele + " ");
        }

        System.out.println();
        for (int num : arr) {
            set.add(num); // duplicates automatically ignored
        }

        System.out.println("Number of distinct elements: " + set.size());
    }
}
