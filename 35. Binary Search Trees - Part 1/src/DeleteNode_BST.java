// Binary Search Tree: Delete a Node in a Binary Search Tree.

public class DeleteNode_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Method to insert in a Binary Search Tree:
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return  root;
        }

        if (root.data > val) { // insert -> left subtree
            root.left = insert(root.left, val);
        } else { // insert -> right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println("Binary Search Tree: Delete a Node in a Binary Search Tree.");
        System.out.println();

        int values[] = {5, 1, 3, 2, 4, 7};
        Node root = null;

        for (int i = 0; i < values.length; i ++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
    }
}
