// Multidimensional ArrayList in Java:

import java.util.ArrayList;

public class MultidimensionalArrayList {
    public static void main(String[] args) {
        // Multidimensional ArrayList Creation:
        ArrayList <ArrayList <Integer>> mainList = new ArrayList<>();

        // List - 1:
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        mainList.add(list);
        System.out.println(list);

        // List - 2:
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);
        System.out.println(list2);

        for(int i = 0; i < mainList.size(); i ++) {
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0; j < currList.size(); j ++) {
                System.out.print(currList.get(j) + " ");
            }
        }
    }
}
