// Greedy Algorithm Problem - Activity Selection. TC = O(n)

import java.util.ArrayList;

public class ActivitySelection {
    public static void main(String[] args) {
        System.out.println("Greedy Algorithm Problem - Activity Selection.");

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9}; // end time bases sorted.
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity:
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for (int i = 0; i < end.length; i ++) {
            if (start[i] >= lastEnd) {
                // Activity Select:
                maxAct ++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("\nMaximum Activities: " + maxAct);
        for (int i = 0; i < ans.size(); i ++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
