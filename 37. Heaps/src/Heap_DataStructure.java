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

                x = par;
                par = (x - 1) / 2;
            }
        }

        // Method to peek data from Heap:
        public int peek() {
            return arr.get(0);
        }

        // Heapify Method:
        private void heapify(int idx) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int minIdx = idx;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != idx) {
                // Swap:
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(idx);
            }
        }

        // Method to delete data from Heap:
        public int remove() {
            int data = arr.get(0);
            int index = 0;

            // Step - 1: Swap 1st & last element:
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step - 2: Delete last element:
            arr.remove(arr.size() - 1);

            // Step - 3: Heapify Method:
            heapify(index);

            return data;
        }

        // Method to check Heap is Empty:
        private boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Heap Data Structure: Heap Implementation.");

        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
