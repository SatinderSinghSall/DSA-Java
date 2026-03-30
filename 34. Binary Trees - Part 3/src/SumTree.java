// Binary Tree: Transform to Sum Tree.

public class SumTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int transform(Node root) {
        if (root == null) return 0;

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int old = root.data;
        root.data = leftSum + rightSum;

        return old + root.data;
    }

    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        transform(root);
        preorder(root); // Output: 5 0 0
    }
}
