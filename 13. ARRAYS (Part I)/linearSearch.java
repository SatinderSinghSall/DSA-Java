//! Linear Search: Java

public class linearSearch {
    // Method for linear search in an integer array:
    public static int LinearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Method for linear search in a String array:
    public static int LinearSearch(String foodMenu[], String key) {
        for (int i = 0; i < foodMenu.length; i++) {
            if (foodMenu[i].equalsIgnoreCase(key)) { // Using equalsIgnoreCase for case-insensitive comparison
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Linear search for integers:
        System.out.println("\nLinear search for integers:");
        int numbers[] = { 2, 4, 6, 8, 10, 12, 14, 16 };

        int key = 100;
        int index = LinearSearch(numbers, key);

        if (index == -1) {
            System.out.println("Key NOT found.");
        } else {
            System.out.println("Key FOUND at index: " + index);
        }

        // Linear search for strings:
        System.out.println("\nLinear search for strings:");
        String foodMenu[] = { "Dosa", "Chole Bhature", "Samosa" };
        String searchItem = "Samosa";
        int foodIndex = LinearSearch(foodMenu, searchItem);

        if (foodIndex == -1) {
            System.out.println("Item NOT found in food menu.");
        } else {
            System.out.println("Item FOUND at index: " + foodIndex);
        }
    }
}
