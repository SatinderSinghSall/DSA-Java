// Binary Tree: Diameter Of a Tree.

public class DiameterOfaTree4 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // HEIGHT OF TREE
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // COUNT OF NODES
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount + rightCount + 1;
    }

    // SUM OF NODES
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    // DIAMETER OF TREE (O(n^2))
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    static class Info {
        int diameter;
        int height;

        public Info(int dimeter, int height) {
            this.diameter = dimeter;
            this.height = height;
        }
    }

    // DIAMETER OF TREE OPTIMIZED (O(n))
    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int selfDiameter = leftInfo.height + rightInfo.height + 1;

        int diameter = Math.max(selfDiameter,
                Math.max(leftInfo.diameter, rightInfo.diameter));

        return new Info(diameter, height);
    }

    public static void main(String args[]) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        System.out.println("Height = " + height(root));
        System.out.println("Count = " + count(root));
        System.out.println("Sum = " + sum(root));
        System.out.println("Diameter = " + diameter(root));

        System.out.println("Diameter (Optimized) = " + diameter2(root).diameter);
    }
}
