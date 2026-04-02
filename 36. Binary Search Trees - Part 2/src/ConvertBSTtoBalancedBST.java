// Binary Search Tree: Convert a BST to a Balanced BST.

import java.util.*;

public class ConvertBSTtoBalancedBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Step 1: Store inorder traversal
    public static void getInorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    // Step 2: Convert sorted list to balanced BST
    public static Node createBalancedBST(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = createBalancedBST(list, start, mid - 1);
        root.right = createBalancedBST(list, mid + 1, end);

        return root;
    }

    // Main function to convert BST → Balanced BST
    public static Node balanceBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        // Step 1
        getInorder(root, list);

        // Step 2
        return createBalancedBST(list, 0, list.size() - 1);
    }

    // Preorder (to check result)
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println("Binary Search Tree: Convert a BST to a Balanced BST.");

        /*
              Unbalanced BST:
                   8
                  /
                 6
                /
               5
              /
             3
        */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        // Convert to Balanced BST
        root = balanceBST(root);

        // Output
        preorder(root);
    }
}
