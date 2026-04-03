// Hashing: Tree Map Operations.

import java.util.TreeMap;
import java.util.Set;

public class TreeMap_Operations {
    public static void main(String[] args) {
        System.out.println("Hashing: TreeMap Operations.");

        // Creating a TreeMap:
        TreeMap<String, Integer> tm = new TreeMap<>();

        // Inserting into a TreeMap: O(log n)
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("USA", 50);
        tm.put("Japan", 80);
        tm.put("Germany", 70);

        // Elements are sorted (natural order - alphabetical):
        System.out.println(tm);

        // Getting an Element: O(log n)
        System.out.println(tm.get("India"));

        // Check if Key Exists: O(log n)
        System.out.println(tm.containsKey("USA")); // true
        System.out.println(tm.containsKey("UK"));  // false

        // Removing an Element: O(log n)
        tm.remove("China");
        System.out.println(tm);

        // Size of TreeMap:
        System.out.println(tm.size());

        // Check if empty:
        System.out.println(tm.isEmpty());

        // Iteration (sorted order):
        Set<String> keys = tm.keySet();

        for (String k : keys) {
            System.out.println("Key: " + k + " & Value: " + tm.get(k));
        }

        // Entry Set:
        System.out.println(tm.entrySet());
    }
}
