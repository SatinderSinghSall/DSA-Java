// Trie: Starts with Problem.

// Trie Node class (renamed to TrieNode3)
class TrieNode3 {

    // Each node has 26 children representing letters a–z
    TrieNode3[] children = new TrieNode3[26];

    // This flag tells if a word ends at this node
    boolean endOfWord = false;

    // Constructor
    TrieNode3() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

class Trie3 {

    // Root node of Trie
    TrieNode3 root = new TrieNode3();

    // -----------------------------
    // INSERT FUNCTION
    // -----------------------------
    public void insert(String word) {

        // Start from root
        TrieNode3 curr = root;

        for (int i = 0; i < word.length(); i++) {

            // Convert character to index (0–25)
            int idx = word.charAt(i) - 'a';

            // If node doesn't exist, create it
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode3();
            }

            // Move to next node
            curr = curr.children[idx];
        }

        // Mark end of the word
        curr.endOfWord = true;
    }

    // -----------------------------
    // STARTSWITH FUNCTION
    // -----------------------------
    public boolean startsWith(String prefix) {

        TrieNode3 curr = root;

        for (int i = 0; i < prefix.length(); i++) {

            // Convert char to index
            int idx = prefix.charAt(i) - 'a';

            // If path doesn't exist → prefix not found
            if (curr.children[idx] == null) {
                return false;
            }

            // Move forward in the trie
            curr = curr.children[idx];
        }

        // Prefix path exists
        return true;
    }

    // -----------------------------
    // MAIN METHOD (TESTING)
    // -----------------------------
    public static void main(String[] args) {

        Trie3 trie = new Trie3();

        String words[] = {"apple", "app", "mango", "man", "woman"};

        // Insert words into trie
        for (String word : words) {
            trie.insert(word);
        }

        // Check prefixes
        System.out.println(trie.startsWith("app"));   // true
        System.out.println(trie.startsWith("moon"));  // false
    }
}
