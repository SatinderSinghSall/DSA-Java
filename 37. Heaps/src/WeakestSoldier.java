// Heap Data Structure: Weakest Soldier.

import java.util.*;

public class WeakestSoldier {

    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        // Constructor
        Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        // Sorting logic for heap
        @Override
        public int compareTo(Row other) {
            if (this.soldiers == other.soldiers) {
                return this.index - other.index; // smaller index first
            }
            return this.soldiers - other.soldiers; // fewer soldiers first
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        // Step 1: Create Min Heap
        PriorityQueue<Row> pq = new PriorityQueue<>();

        // Step 2: Count soldiers in each row
        for (int i = 0; i < mat.length; i++) {
            int count = 0;

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break; // because 1s are always before 0s
                }
            }

            // Add row info to heap
            pq.add(new Row(count, i));
        }

        // Step 3: Extract k weakest rows
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().index;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Heap Data Structure: Weakest Soldier.");

        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };

        int k = 2;

        int[] ans = kWeakestRows(mat, k);

        // Print result
        System.out.print("Weakest rows: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
