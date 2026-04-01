// Binary Search Tree: Sorted Array to Balanced Binary Search Tree.

public class SortedArrayBalancedBST {
    static class  Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println("Binary Search Tree: Sorted Array to Balanced Binary Search Tree.");

        int arr[] = {3, 5, 6, 8, 10, 11, 12};
    }
}
