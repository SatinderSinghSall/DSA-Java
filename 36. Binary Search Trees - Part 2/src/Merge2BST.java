// Binary Search Tree: Merge 2 Binary Search Trees.

import java.util.*;

public class Merge2BST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Step 1: Inorder traversal
    public static void getInorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    // Step 2: Merge two sorted lists
    public static ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> merged = new ArrayList<>();

        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }

        // remaining elements
        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));

        return merged;
    }

    // Step 3: Build Balanced BST
    public static Node createBST(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = createBST(list, start, mid - 1);
        root.right = createBST(list, mid + 1, end);

        return root;
    }

    // Merge BSTs
    public static Node mergeBSTs(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        getInorder(root1, list1);
        getInorder(root2, list2);

        ArrayList<Integer> merged = mergeLists(list1, list2);

        return createBST(merged, 0, merged.size() - 1);
    }

    // Preorder for checking
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        /*
            BST 1:
                2
               / \
              1   4

            BST 2:
                9
               / \
              3   12
        */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);

        preorder(root);
    }
}
