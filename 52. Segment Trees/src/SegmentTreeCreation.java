// Segment Trees: Construction of Segment Tree

// Problem:
// Construct a Segment Tree for range sum queries.

// Example:
// arr[] = {1, 2, 3, 4, 5, 6, 7, 8}

// Tree Representation:
//
// tree[0] -> total sum
// left child  -> 2*i + 1
// right child -> 2*i + 2

// Time Complexity:

// Build Segment Tree : O(n)


// Space Complexity:

// Segment Tree Array : O(4 * n)

import java.util.Arrays;

public class SegmentTreeCreation {

    static int tree[];

    // Build Segment Tree
    public static int buildST(int arr[],
                              int i,
                              int start,
                              int end) {

        // leaf node
        if (start == end) {

            tree[i] = arr[start];

            return arr[start];
        }

        int mid = (start + end) / 2;

        // left subtree
        int left = buildST(
                arr,
                2 * i + 1,
                start,
                mid
        );

        // right subtree
        int right = buildST(
                arr,
                2 * i + 2,
                mid + 1,
                end
        );

        // store sum
        tree[i] = left + right;

        return tree[i];
    }

    // Print Segment Tree
    public static void printTree() {

        System.out.println(
                Arrays.toString(tree)
        );
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        int n = arr.length;

        // segment tree size
        tree = new int[4 * n];

        // build segment tree
        buildST(
                arr,
                0,
                0,
                n - 1
        );

        // print segment tree
        printTree();
    }
}
