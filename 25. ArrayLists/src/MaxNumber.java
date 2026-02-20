// To find maximum number in an array list:

import java.util.ArrayList;

public class MaxNumber {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println(list);

        int maxNumber = list.get(0);
        for(int i = 0; i < list.size(); i ++) {
            if(list.get(i) > maxNumber) {
                maxNumber = list.get(i);
            }
        }

        System.out.println(maxNumber);
    }
}
