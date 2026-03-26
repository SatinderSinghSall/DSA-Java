// Greedy Algorithm Problem - Job Sequencing Problem.

// Problem: Given jobs with deadlines and profits,
// schedule jobs to maximize total profit such that
// only one job can be done at a time and each job takes 1 unit time.

import java.util.*;

public class JobSequencing {

    // Job class to store id, deadline, and profit
    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {

        // Example input
        Job[] jobs = {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };

        jobSequencing(jobs);
    }

    public static void jobSequencing(Job[] jobs) {

        // Step 1: Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Create a slot array to keep track of free time slots
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1); // -1 means empty slot

        int totalProfit = 0;

        // Step 4: Assign jobs to latest possible free slot
        for (Job job : jobs) {

            // Try to schedule job before its deadline
            for (int j = job.deadline; j > 0; j--) {

                // If slot is free
                if (slot[j] == -1) {
                    slot[j] = job.id; // assign job
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Step 5: Print result
        System.out.print("Jobs done: ");
        for (int i = 1; i < slot.length; i++) {
            if (slot[i] != -1) {
                System.out.print("J" + slot[i] + " ");
            }
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
