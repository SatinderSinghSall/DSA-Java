// Array List & Operations:

import java.util.ArrayList;

public class ArrayLists_Java {
    public static void main(String[] args) {
        // ArrayList Creation:
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        // ArrayList Operations:

        // 1. Add Elements: O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1, 9);
        System.out.println(list);

        // 2. Get Element: O(1)
        int ele = list.get(2);
        System.out.println(ele);

        // 3. Remove Element: O(n)
        list.remove(2);
        System.out.println(list);

        // 4. Set Element at Inex: O(n)
        list.set(2, 10);
        System.out.println(list);

        // 5. Contains Element: O(n)
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));
    }
}
