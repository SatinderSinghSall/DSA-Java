// Trie: Trie Data Structure Implementation.

public class Trie_Implementation {

    // Creating a Trie:
    static class Node {
        Node children[] = new Node[26];
        boolean endOfNode = false;

        Node() {
            for (int i = 0; i < 26; i ++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void main(String[] args) {
        System.out.println("Trie: Trie Data Structure Implementation.");

        String words[] = {"the", "a", "there", "their", "any", "there"};
    }
}
