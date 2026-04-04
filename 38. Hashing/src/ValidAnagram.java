// Hashing: Valid Anagram (Using HashMap)

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {

        // Input strings
        String s = "race";
        String t = "care";

        // Step 1: If lengths are different → not anagram
        if (s.length() != t.length()) {
            System.out.println("False");
            return;
        }

        // Step 2: Create HashMap to store frequency of characters
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 3: Count characters in string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Increase count if already present
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            // Otherwise add with count 1
            else {
                map.put(ch, 1);
            }
        }

        // Step 4: Decrease frequency using string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If character not found → not anagram
            if (!map.containsKey(ch)) {
                System.out.println("False");
                return;
            }

            // Decrease count
            map.put(ch, map.get(ch) - 1);

            // If count becomes 0 → remove from map
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        // Step 5: If map is empty → valid anagram
        if (map.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
