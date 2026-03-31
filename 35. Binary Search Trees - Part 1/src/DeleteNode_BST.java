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

    // Method to insert in a Binary Search Tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search in BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Find Inorder Successor (smallest in right subtree)
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete a node
    public static Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.data) {
            root.left = delete(root.left, value);
        }

        else if (value > root.data) {
            root.right = delete(root.right, value);
        }

        else { // Node found

            // Case 1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }

            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static void main(String[] args) {

        System.out.println("Binary Search Tree: Delete a Node in a BST\n");

        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.print("Original BST (Inorder): ");
        inorder(root);
        System.out.println();

        root = delete(root, 5);

        System.out.print("BST after deleting 5: ");
        inorder(root);
        System.out.println();
    }
}
