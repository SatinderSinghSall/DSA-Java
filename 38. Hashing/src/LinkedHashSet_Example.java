// Hashing: LinkedHashSet Example.

import java.util.LinkedHashSet;

public class LinkedHashSet_Example {
    public static void main(String[] args) {
        System.out.println("Hashing: LinkedHashSet Example.");

        // Creating a LinkedHashSet
        // It stores unique elements like HashSet
        // BUT maintains insertion order
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        // Adding elements
        lhs.add(10);
        lhs.add(20);
        lhs.add(30);
        lhs.add(10); // Duplicate, ignored

        // Output will maintain insertion order
        System.out.println(lhs); // [10, 20, 30]

        // Removing element
        lhs.remove(20);

        // Check if element exists
        System.out.println(lhs.contains(10)); // true

        // Size of set
        System.out.println(lhs.size());
    }
}
