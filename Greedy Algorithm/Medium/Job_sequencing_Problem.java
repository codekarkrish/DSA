import java.util.*;

// Job Sequencing Problem
public class Job_sequencing_Problem {

    static class Solution {

        // Returns {Number of Jobs Done, Total Profit}
        public int[] JobScheduling(int[][] Jobs) {

            // Sort jobs by profit in descending order
            Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

            // Find maximum deadline
            int maxDeadline = 0;
            for (int[] job : Jobs) {
                maxDeadline = Math.max(maxDeadline, job[1]);
            }

            // Create slots and mark all as empty
            int[] slot = new int[maxDeadline + 1];
            Arrays.fill(slot, -1);

            int countJobs = 0;
            int totalProfit = 0;

            // Schedule jobs
            for (int i = 0; i < Jobs.length; i++) {

                int deadline = Jobs[i][1];
                int profit = Jobs[i][2];

                // Find a free slot before deadline
                for (int j = deadline; j > 0; j--) {
                    if (slot[j] == -1) {
                        slot[j] = i;
                        countJobs++;
                        totalProfit += profit;
                        break;
                    }
                }
            }

            return new int[]{countJobs, totalProfit};
        }
    }

    public static void main(String[] args) {

        int[][] Jobs = {
            {1, 4, 20},
            {2, 1, 10},
            {3, 2, 40},
            {4, 2, 30}
        };

        Solution sol = new Solution();

        int[] result = sol.JobScheduling(Jobs);

        System.out.println("Number of Jobs Done: " + result[0]);
        System.out.println("Total Profit: " + result[1]);
    }
}

/*
Problem: Job Sequencing Problem

Approach: Greedy + Sorting

TC: O(N log N + N * D)
    N = Number of Jobs
    D = Maximum Deadline

SC: O(D)
*/