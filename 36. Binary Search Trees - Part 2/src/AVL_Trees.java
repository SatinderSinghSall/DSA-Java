// Binary Search Tree: AVL Trees. (Self Balancing BSTs)

public class AVL_Trees {

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    // Get height
    public static int height(Node root) {
        return root == null ? 0 : root.height;
    }

    // Get balance factor
    public static int getBalance(Node root) {
        return root == null ? 0 : height(root.left) - height(root.right);
    }

    // Right Rotation
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left Rotation
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert in AVL Tree
    public static Node insert(Node root, int key) {
        // Normal BST insertion
        if (root == null) return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root;

        // Update height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get balance factor
        int balance = getBalance(root);

        // LL Case
        if (balance > 1 && key < root.left.data)
            return rightRotate(root);

        // RR Case
        if (balance < -1 && key > root.right.data)
            return leftRotate(root);

        // LR Case
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL Case
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;

        int values[] = {10, 20, 30, 40, 50, 25};

        for (int val : values) {
            root = insert(root, val);
        }

        preorder(root);
    }
}
