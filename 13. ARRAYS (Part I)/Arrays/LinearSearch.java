// Linear Search:

package Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int marks[] = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 11;
        boolean found = false;

        for(int i = 0; i < marks.length; i ++) {
            if(marks[i] == key) {
                System.out.println("Found the key " + key + " at index " + i);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Key " + key + " not found.");
        }
    }
}
