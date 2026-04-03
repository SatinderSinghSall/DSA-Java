// Heap Data Structure: Heap Sort Algorithm.

public class HeapSortAlgorithm {
    // Main Heap Sort method
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build Max Heap (Rearrange array)
        // Start from last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest element) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain max heap property
    public static void heapify(int arr[], int n, int i) {
        int largest = i;        // Initialize largest as root
        int left = 2 * i + 1;   // Left child index
        int right = 2 * i + 2;  // Right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap root with largest child
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        System.out.println("Heap Data Structure: Heap Sort Algorithm.");

        // Input array
        int arr[] = {1, 2, 4, 5, 3};

        // Call heap sort function
        heapSort(arr);

        // Print sorted array
        System.out.print("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
