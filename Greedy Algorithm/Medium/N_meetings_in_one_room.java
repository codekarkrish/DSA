import java.util.*;

// N Meetings in One Room
public class N_meetings_in_one_room {

    static class Solution {
        public int maxMeetings(int[] start, int[] end) {
            int n = start.length;

            // Store meetings as {endTime, startTime}
            int[][] meetings = new int[n][2];

            for (int i = 0; i < n; i++) {
                meetings[i][0] = end[i];
                meetings[i][1] = start[i];
            }

            // Sort meetings by end time
            Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

            int count = 0;
            int lastEnd = -1;

            // Select meetings greedily
            for (int[] meeting : meetings) {
                if (meeting[1] > lastEnd) {
                    count++;
                    lastEnd = meeting[0];
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        Solution sol = new Solution();
        int result = sol.maxMeetings(start, end);

        System.out.println("Maximum meetings: " + result);
    }
}

/*
Problem: N Meetings in One Room (Greedy)

TC: O(N log N)  // Sorting meetings
SC: O(N)        // Extra array for meetings
*/