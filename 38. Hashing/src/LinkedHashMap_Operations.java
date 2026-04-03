// Hashing: Linked HashMap Operations.

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMap_Operations {
    public static void main(String[] args) {
        System.out.println("Hashing: LinkedHashMap Operations.");

        // Creating a LinkedHashMap:
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        // Inserting into a LinkedHashMap: O(1)
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("USA", 50);
        lhm.put("Japan", 80);
        lhm.put("Germany", 70);

        // Maintains insertion order:
        System.out.println(lhm);

        // Getting an Element: O(1)
        System.out.println(lhm.get("India"));

        // Check if Key Exists: O(1)
        System.out.println(lhm.containsKey("USA")); // true
        System.out.println(lhm.containsKey("UK"));  // false

        // Removing an Element: O(1)
        lhm.remove("China");
        System.out.println(lhm);

        // Size of LinkedHashMap:
        System.out.println(lhm.size());

        // Check if empty:
        System.out.println(lhm.isEmpty());

        // Iteration (in insertion order):
        Set<String> keys = lhm.keySet();

        for (String k : keys) {
            System.out.println("Key: " + k + " & Value: " + lhm.get(k));
        }

        // Entry Set:
        System.out.println(lhm.entrySet());
    }
}
