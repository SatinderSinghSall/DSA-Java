// Hashing: Count Distinct Elements.

// Hashing: Count Distinct Elements using HashSet.

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        System.out.println("Hashing: Count Distinct Elements.");

        int[] arr = {10, 20, 20, 30, 40, 10, 50};

        HashSet<Integer> set = new HashSet<>();

        System.out.print("Array elements: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }

        for (int num : arr) {
            set.add(num);
        }

        System.out.println("\nDistinct elements: " + set);
        System.out.println("Number of distinct elements: " + set.size());
    }
}
