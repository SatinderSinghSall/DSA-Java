// Tries: Longest Word with All Prefixes using Trie

// Trie Node class
class TrieNode5 {

    TrieNode5[] children = new TrieNode5[26];
    boolean endOfWord = false;
}

class Trie5 {

    static TrieNode5 root = new TrieNode5();
    static String ans = "";

    // Insert word into Trie
    public static void insert(String word) {

        TrieNode5 curr = root;

        for(int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode5();
            }

            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    // DFS to find longest word
    public static void longestWord(TrieNode5 root, StringBuilder temp) {

        if(root == null) {
            return;
        }

        for(int i = 0; i < 26; i++) {

            if(root.children[i] != null && root.children[i].endOfWord == true) {

                // add character
                char ch = (char)(i + 'a');
                temp.append(ch);

                // update answer if longer
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                // continue DFS
                longestWord(root.children[i], temp);

                // backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        String words[] = {"a","banana","app","appl","ap","apply","apple"};

        // insert words
        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder());

        System.out.println("Longest Word = " + ans);
    }
}
