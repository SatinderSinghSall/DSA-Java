// Binary Tree: Minimum Distance Between 2 Nodes.

public class MinDistance {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

    public static int distance(Node root, int target) {
        if (root == null) return -1;

        if (root.data == target) return 0;

        int left = distance(root.left, target);
        int right = distance(root.right, target);

        if (left == -1 && right == -1) return -1;

        return Math.max(left, right) + 1;
    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lcaNode = lca(root, n1, n2);

        int d1 = distance(lcaNode, n1);
        int d2 = distance(lcaNode, n2);

        return d1 + d2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println(minDistance(root, 4, 3)); // Output: 3
    }
}
