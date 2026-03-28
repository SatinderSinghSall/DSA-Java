// Binary Trees: Count of Nodes of a Tree.

public class CountNodesTree {
    static class Node {
        int data;
        LevelOrderTraversal.Node left;
        LevelOrderTraversal.Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static LevelOrderTraversal.Node buildTree(int nodes[]) {
            index++;

            if (nodes[index] == -1) {
                return null;
            }

            LevelOrderTraversal.Node newNode = new LevelOrderTraversal.Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void main(String[] args) {
        System.out.println("Binary Trees: Count of Nodes of a Tree.");

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        LevelOrderTraversal.BinaryTree tree = new LevelOrderTraversal.BinaryTree();
        LevelOrderTraversal.Node root = tree.buildTree(nodes);

        System.out.println(root.data);
    }
}
