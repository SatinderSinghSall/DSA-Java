// Binary Tree: Diameter Of a Tree.

public class DiameterOfaTree {

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

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;

            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // HEIGHT FUNCTION
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // DIAMETER FUNCTION (O(n^2))
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

    public static void main(String[] args) {
        System.out.println("Binary Tree: Diameter Of a Tree.");

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println("Diameter = " + diameter(root));
    }
}
