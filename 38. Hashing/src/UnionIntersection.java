// Hashing: Union & Intersection of 2 arrays using HashSet.

import java.util.HashSet;

public class UnionIntersection {
    public static void main(String[] args) {
        System.out.println("Hashing: Union & Intersection of 2 arrays using HashSet.");

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        // ----------- UNION -----------
        HashSet<Integer> union = new HashSet<>();

        for (int num : arr1) {
            union.add(num);
        }

        for (int num : arr2) {
            union.add(num);
        }

        System.out.println("Union: " + union);
        System.out.println("Union size: " + union.size());

        // ----------- INTERSECTION -----------
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        // Add arr1 elements to set
        for (int num : arr1) {
            set.add(num);
        }

        // Check arr2 elements
        for (int num : arr2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        System.out.println("Intersection: " + intersection);
        System.out.println("Intersection size: " + intersection.size());
    }
}
