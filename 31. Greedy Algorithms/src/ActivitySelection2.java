// Greedy Algorithm Problem - Activity Selection. TC = O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection2 {
    public static void main(String[] args) {
        System.out.println("Greedy Algorithm Problem - Activity Selection.");

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9}; // end time bases sorted.
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // Sorting:
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i ++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Lambda Function / Method: Sorted 2D Array
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // 1st Activity:
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 0; i < end.length; i ++) {
            if (activities[i][1] >= lastEnd) {
                // Activity Select:
                maxAct ++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("\nMaximum Activities: " + maxAct);
        for (int i = 0; i < ans.size(); i ++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
