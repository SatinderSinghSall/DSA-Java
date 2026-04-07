// Trie: Trie Data Structure Implementation.

public class Trie_Implementation {

    // Creating a Trie:
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < 26; i ++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Inserting en Element into a Trie: Time Complexity - O(L) where L is the 'Length of the largest word'.
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level ++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    // Method to Search in a Trie: Time Complexity - O(L) where L is the 'Length of the largest word'.
    public static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.endOfWord;
    }

    public static void main(String[] args) {
        System.out.println("Trie: Trie Data Structure Implementation.");

        String words[] = {"the", "a", "there", "their", "any", "there"};

        for (int i = 0; i < words.length; i ++) {
            insert(words[i]);
        }

        System.out.println(search("there")); // true
        System.out.println(search("their")); // true
        System.out.println(search("thor"));  // false
        System.out.println(search("an"));    // false
    }
}
