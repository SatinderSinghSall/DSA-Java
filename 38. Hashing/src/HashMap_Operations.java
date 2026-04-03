// Hashing: HashMap Operations.

import java.util.HashMap;

public class HashMap_Operations {
    public static void main(String[] args) {
        System.out.println("Hashing: HashMap Operations.");

        // Creating a HashMap:
        HashMap<String, Integer> hm = new HashMap<>();

        // Inserting into a HashMap: O(1) Time Complexity
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);

        System.out.println(hm);

        // Getting an Element from a HashMap: O(1) Time Complexity
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("UK")); // null no key present

        // Check if an Element is Present in a HashMap: O(1)
        System.out.println(hm.containsKey("UK")); // False - not present
        System.out.println(hm.containsKey("India")); // True - present

        // Removing an Element from a HashMap: O(1)
        hm.remove("USA");
        System.out.println(hm.remove("UK")); // null

        System.out.println(hm);

        // Method - 'size()' to get the HashMap size-length:
        System.out.println(hm.size());

        // Method - 'isEmpty()' to check if HashMap is empty or not:
        System.out.println(hm.isEmpty()); // false

        // Method - 'clear()' to clear full HashMa:
//        System.out.println(hm.clear()); // true
    }
}
