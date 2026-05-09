// Segment Trees: Max Segment Tree

// Problem:
// Perform following operations using Segment Tree:
//
// 1. Build Max Segment Tree
// 2. Range Maximum Query
// 3. Update Element at Index

// Example:
// arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4}

// Time Complexity:

// Build Segment Tree : O(n)
// Range Query        : O(log n)
// Update Query       : O(log n)


// Space Complexity:

// Segment Tree Array : O(4 * n)

import java.util.Arrays;

public class MaxSegmentTree {

    static int tree[];

    // Build Max Segment Tree
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

        // store maximum
        tree[i] = Math.max(left, right);

        return tree[i];
    }

    // Range Maximum Query
    public static int getMax(int i,
                             int si,
                             int sj,
                             int qi,
                             int qj) {

        // no overlap
        if (qj < si || qi > sj) {

            return Integer.MIN_VALUE;
        }

        // complete overlap
        if (si >= qi && sj <= qj) {

            return tree[i];
        }

        // partial overlap
        int mid = (si + sj) / 2;

        int left = getMax(
                2 * i + 1,
                si,
                mid,
                qi,
                qj
        );

        int right = getMax(
                2 * i + 2,
                mid + 1,
                sj,
                qi,
                qj
        );

        return Math.max(left, right);
    }

    // Update Utility Function
    public static void updateUtil(int i,
                                  int si,
                                  int sj,
                                  int idx,
                                  int newVal) {

        // index outside range
        if (idx < si || idx > sj) {
            return;
        }

        // leaf node
        if (si == sj) {

            tree[i] = newVal;

            return;
        }

        int mid = (si + sj) / 2;

        // left subtree
        updateUtil(
                2 * i + 1,
                si,
                mid,
                idx,
                newVal
        );

        // right subtree
        updateUtil(
                2 * i + 2,
                mid + 1,
                sj,
                idx,
                newVal
        );

        // update current node
        tree[i] = Math.max(
                tree[2 * i + 1],
                tree[2 * i + 2]
        );
    }

    // Update Function
    public static void update(int arr[],
                              int idx,
                              int newVal) {

        arr[idx] = newVal;

        updateUtil(
                0,
                0,
                arr.length - 1,
                idx,
                newVal
        );
    }

    // Print Segment Tree
    public static void printTree() {

        System.out.println(
                Arrays.toString(tree)
        );
    }

    public static void main(String[] args) {

        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};

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

        System.out.println("Initial Segment Tree:");

        printTree();

        // range max query
        int qi = 2;
        int qj = 5;

        int ans = getMax(
                0,
                0,
                n - 1,
                qi,
                qj
        );

        System.out.println(
                "\nMaximum in range = " + ans
        );

        // update value
        update(arr, 2, 20);

        System.out.println("\nAfter Update:");

        printTree();

        // query again
        ans = getMax(
                0,
                0,
                n - 1,
                qi,
                qj
        );

        System.out.println(
                "\nMaximum in range = " + ans
        );
    }
}
