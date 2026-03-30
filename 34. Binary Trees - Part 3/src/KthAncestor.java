// Binary Tree: Kth Ancestor of a Node.

public class KthAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int kthAncestor(Node root, int target, int k) {
        return helper(root, target, k);
    }

    static int helper(Node root, int target, int k) {
        if (root == null) return -1;

        if (root.data == target) return 0;

        int left = helper(root.left, target, k);
        int right = helper(root.right, target, k);

        int dist = Math.max(left, right);

        if (dist != -1) {
            if (dist + 1 == k) {
                System.out.println("Kth Ancestor: " + root.data);
            }
            return dist + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);

        kthAncestor(root, 4, 2); // Output: 1
    }
}
