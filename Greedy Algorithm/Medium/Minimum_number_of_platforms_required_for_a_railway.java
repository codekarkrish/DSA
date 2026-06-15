import java.util.Arrays;

// Minimum Number of Platforms Required for a Railway
public class Minimum_number_of_platforms_required_for_a_railway {

    static class Solution {

        // Function to find minimum platforms required
        public int findPlatform(int[] Arrival, int[] Departure) {
            int n = Arrival.length;

            // Sort arrival and departure times
            Arrays.sort(Arrival);
            Arrays.sort(Departure);

            int platforms = 1;
            int maxPlatforms = 1;

            int i = 1, j = 0;

            // Traverse both arrays
            while (i < n && j < n) {

                // Train arrives before previous train departs
                if (Arrival[i] <= Departure[j]) {
                    platforms++;
                    i++;
                } else {
                    // Train departs, platform becomes free
                    platforms--;
                    j++;
                }

                maxPlatforms = Math.max(maxPlatforms, platforms);
            }

            return maxPlatforms;
        }
    }

    public static void main(String[] args) {

        int[] Arrival = {900, 945, 955, 1100, 1500, 1800};
        int[] Departure = {920, 1200, 1130, 1150, 1900, 2000};

        Solution sol = new Solution();

        int result = sol.findPlatform(Arrival, Departure);

        System.out.println("Minimum Platforms Required: " + result);
    }
}

/*
Problem: Minimum Number of Platforms Required for a Railway

Approach: Greedy + Sorting

TC: O(N log N)   // Sorting arrival and departure arrays
SC: O(1)         // No extra space used (excluding sorting)
*/