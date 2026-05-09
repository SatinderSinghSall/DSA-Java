// Segment Trees: Update on Segment Tree

// Problem:
// Update value at a given index
// and update Segment Tree accordingly.

// Example:
// arr[] = {1, 2, 3, 4, 5, 6, 7, 8}

// Update:
// idx = 2
// newValue = 2

// Time Complexity:

// Build Segment Tree : O(n)
// Update Query       : O(log n)


// Space Complexity:

// Segment Tree Array : O(4 * n)

import java.util.Arrays;

public class SegmentTreeUpdate {

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

    // Update Utility Function
    public static void updateUtil(int i,
                                  int si,
                                  int sj,
                                  int idx,
                                  int diff) {

        // index not inside range
        if (idx < si || idx > sj) {
            return;
        }

        // update current node
        tree[i] += diff;

        // non-leaf node
        if (si != sj) {

            int mid = (si + sj) / 2;

            // left subtree
            updateUtil(
                    2 * i + 1,
                    si,
                    mid,
                    idx,
                    diff
            );

            // right subtree
            updateUtil(
                    2 * i + 2,
                    mid + 1,
                    sj,
                    idx,
                    diff
            );
        }
    }

    // Update Function
    public static void update(int arr[],
                              int idx,
                              int newVal) {

        int diff = newVal - arr[idx];

        // update original array
        arr[idx] = newVal;

        // update segment tree
        updateUtil(
                0,
                0,
                arr.length - 1,
                idx,
                diff
        );
    }

    // Range Sum Query
    public static int getSum(int i,
                             int si,
                             int sj,
                             int qi,
                             int qj) {

        // no overlap
        if (qj < si || qi > sj) {
            return 0;
        }

        // complete overlap
        if (si >= qi && sj <= qj) {
            return tree[i];
        }

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

        System.out.println("Before Update:");

        printTree();

        // range sum before update
        System.out.println(
                "Sum (2 to 5) = " +
                        getSum(0, 0, n - 1, 2, 5)
        );

        // update index
        update(arr, 2, 2);

        System.out.println("\nAfter Update:");

        printTree();

        // range sum after update
        System.out.println(
                "Sum (2 to 5) = " +
                        getSum(0, 0, n - 1, 2, 5)
        );
    }
}
