// Trie: Prefix Problem.

import java.util.*;

class TrieNode2 {
    TrieNode2[] children = new TrieNode2[26];
    int freq = 0; // number of words passing through this node
}

class Trie2 {
    TrieNode2 root = new TrieNode2();

    // Insert word into Trie
    public void insert(String word) {
        TrieNode2 node = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode2();
            }

            node = node.children[idx];
            node.freq++; // increment frequency
        }
    }

    // Get shortest unique prefix
    public String getUniquePrefix(String word) {
        TrieNode2 node = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            node = node.children[idx];
            prefix.append(ch);

            if (node.freq == 1) {
                break;
            }
        }

        return prefix.toString();
    }
}

public class Prefix_Problem {

    public static void main(String[] args) {
        System.out.println("Trie: Prefix Problem.");

        String[] words = {"zebra", "dog", "duck", "dove"};

        Trie2 trie = new Trie2();

        // Insert words
        for (String word : words) {
            trie.insert(word);
        }

        // Print unique prefixes
        for (String word : words) {
            System.out.println(word + " -> " + trie.getUniquePrefix(word));
        }
    }
}
