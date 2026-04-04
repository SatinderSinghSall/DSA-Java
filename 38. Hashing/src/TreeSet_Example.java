// Hashing: TreeSet Example.

import java.util.TreeSet;

public class TreeSet_Example {
    public static void main(String[] args) {
        System.out.println("Hashing: TreeSet Example.");

        // Creating a TreeSet
        // Stores elements in sorted (ascending) order
        TreeSet<Integer> ts = new TreeSet<>();

        // Adding elements
        ts.add(50);
        ts.add(20);
        ts.add(40);
        ts.add(10);

        // Output will be sorted automatically
        System.out.println(ts); // [10, 20, 40, 50]

        // Remove element
        ts.remove(20);

        // Check existence
        System.out.println(ts.contains(40)); // true

        // First and last elements
        System.out.println(ts.first()); // smallest
        System.out.println(ts.last());  // largest
    }
}
