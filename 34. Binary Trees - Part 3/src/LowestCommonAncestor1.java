// Binary Tree: Lowest Common Ancestor Path - Approach 1.

import java.util.*;

public class LowestCommonAncestor1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean getPath(Node root, int target, List<Node> path) {
        if (root == null) return false;

        path.add(root);

        if (root.data == target) return true;

        if (getPath(root.left, target, path) || getPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) break;
            i++;
        }

        return path1.get(i - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(lca(root, 4, 5).data); // Output: 2
    }
}
