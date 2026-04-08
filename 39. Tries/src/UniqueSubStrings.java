// Tries: Count Unique Substrings using Trie.

// Trie Node class
class TrieNode4 {

    // Array to store children nodes for 26 lowercase letters
    TrieNode4[] children = new TrieNode4[26];
}

public class UniqueSubStrings {

    // Root node of Trie
    static TrieNode4 root = new TrieNode4();

    // Insert function
    public static int insert(String word) {

        TrieNode4 curr = root;
        int newNodes = 0;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode4();
                newNodes++;
            }

            curr = curr.children[idx];
        }

        return newNodes;
    }

    public static void main(String[] args) {

        String str = "ababa";
        int count = 0;

        // Insert all suffixes
        for (int i = 0; i < str.length(); i++) {

            String suffix = str.substring(i);
            count += insert(suffix);
        }

        // +1 for empty substring
        System.out.println("Total Unique Substrings = " + (count + 1));
    }
}
