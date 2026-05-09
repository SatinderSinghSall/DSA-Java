// Segment Trees: Query on Segment Tree

// Problem:
// Find sum of elements in a given range
// using Segment Tree.

// Example:
// arr[] = {1, 2, 3, 4, 5, 6, 7, 8}

// Query:
// sum from index 2 to 5

// Time Complexity:

// Build Segment Tree : O(n)
// Range Query        : O(log n)


// Space Complexity:

// Segment Tree Array : O(4 * n)

import java.util.Arrays;

public class SegmentTreeQuery {

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

    // Range Sum Query
    public static int getSum(int i,
                             int si,
                             int sj,
                             int qi,
                             int qj) {

        // case 1:
        // no overlap
        if (qj < si || qi > sj) {

            return 0;
        }

        // case 2:
        // complete overlap
        if (si >= qi && sj <= qj) {

            return tree[i];
        }

        // case 3:
        // partial overlap

        int mid = (si + sj) / 2;

        int left = getSum(
                2 * i + 1,
                si,
                mid,
                qi,
                qj
        );

        int right = getSum(
                2 * i + 2,
                mid + 1,
                sj,
                qi,
                qj
        );

        return left + right;
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

        // initialize segment tree
        tree = new int[4 * n];

        // build segment tree
        buildST(
                arr,
                0,
                0,
                n - 1
        );

        // print tree
        printTree();

        // query range
        int qi = 2;
        int qj = 5;

        int ans = getSum(
                0,
                0,
                n - 1,
                qi,
                qj
        );

        System.out.println(
                "Sum in range = " + ans
        );
    }
}
