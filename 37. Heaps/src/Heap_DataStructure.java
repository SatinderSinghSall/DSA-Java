// Heap Data Structure: Heap Implementation.

import java.util.ArrayList;

public class Heap_DataStructure {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Method to add a data in Heap:
        public void add(int data) { // O(logn)
            // Add at last index:
            arr.add(data);

            int x = arr.size() - 1; // child index
            int par = (arr.size() - 2) / 2; // parent index

            while (arr.get(x) < arr.get(par)) { // O(logn)
                // Swap:
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }

        // Method to peek data from Heap:
        public int peek() {
            return arr.get(0);
        }

        // Method to delete data from Heap:
    }

    public static void main(String[] args) {
        System.out.println("Heap Data Structure: Heap Implementation.");
    }
}
