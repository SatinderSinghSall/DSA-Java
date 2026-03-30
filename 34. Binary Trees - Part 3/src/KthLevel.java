// Binary Tree: Kth Level of a Binary Tree.

public class KthLevel {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printKthLevel(Node root, int k) {
        helper(root, 1, k);
        System.out.println();
    }

    private static void helper(Node root, int level, int k) {
        if (root == null) return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        helper(root.left, level + 1, k);
        helper(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        printKthLevel(root, 2); // Output: 2 3
    }
}
