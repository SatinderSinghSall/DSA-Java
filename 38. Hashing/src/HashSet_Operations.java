// Hashing: HashSet Data Structure.

// Hashing: HashMap Operations.

// Import HashMap class for storing key-value pairs
import java.util.HashMap;

// Import Set interface for keySet() method
import java.util.Set;

// Define class
public class HashSet_Operations {

    // Main method - entry point of program
    public static void main(String[] args) {

        // Print heading
        System.out.println("Hashing: HashMap Operations.");

        // Creating a HashMap
        // Syntax: HashMap<KeyType, ValueType>
        HashMap<String, Integer> hm = new HashMap<>();

        // ------------------ INSERTION ------------------
        // put(key, value) -> adds key-value pair
        // Time Complexity: O(1) average
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Japan", 80);
        hm.put("Germany", 70);
        hm.put("France", 65);
        hm.put("UK", 60);
        hm.put("Canada", 55);

        // Print entire HashMap
        System.out.println(hm);

        // ------------------ ACCESS / GET ------------------
        // get(key) -> returns value of given key
        // Time Complexity: O(1)
        int population = hm.get("India");
        System.out.println(population);

        // If key does not exist, returns null
        System.out.println(hm.get("UK")); // returns value or null if absent

        // ------------------ SEARCH ------------------
        // containsKey(key) -> checks if key exists
        // Time Complexity: O(1)
        System.out.println(hm.containsKey("UK"));     // true if present
        System.out.println(hm.containsKey("India"));  // true

        // ------------------ DELETE ------------------
        // remove(key) -> removes key-value pair
        // Time Complexity: O(1)
        hm.remove("USA"); // removes USA entry

        // Removing non-existing key returns null
        System.out.println(hm.remove("UK"));

        // Print updated HashMap
        System.out.println(hm);

        // ------------------ SIZE ------------------
        // size() -> returns number of key-value pairs
        System.out.println(hm.size());

        // ------------------ EMPTY CHECK ------------------
        // isEmpty() -> returns true if map is empty
        System.out.println(hm.isEmpty()); // false

        // ------------------ CLEAR ------------------
        // clear() -> removes all elements
        // hm.clear();

        // ------------------ ITERATION ------------------
        // keySet() -> returns all keys
        Set<String> key = hm.keySet();
        System.out.println(key);

        System.out.println();

        // Loop through keys and print key-value pairs
        for (String k : key) {
            System.out.println("Key: " + k + " & Value: " + hm.get(k));
        }

        System.out.println();

        // entrySet() -> returns all key-value pairs as Set
        System.out.println(hm.entrySet());
    }
}
