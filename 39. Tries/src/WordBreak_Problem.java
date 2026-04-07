// Trie: Word Break Problem.

import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert word into Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
}

public class WordBreak_Problem {

    // Function to check word break using Trie + DP
    public static boolean wordBreak(String s, Trie trie) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            TrieNode node = trie.root;
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';

                if (node.children[index] == null) break;

                node = node.children[index];

                if (node.isEndOfWord) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Trie: Word Break Problem.");

        String[] dictionary = {"leet", "code", "apple", "pen"};
        String input = "leetcode";

        Trie trie = new Trie();

        for (String word : dictionary) {
            trie.insert(word);
        }

        boolean result = wordBreak(input, trie);
        System.out.println("Can be segmented: " + result);
    }
}
