import java.util.*;

public class Aggressive_Cows {

    // Check if we can place cows with at least 'dist' distance
    public static boolean canPlace(int[] stalls, int cows, int dist) {

        int count = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
            }

            if (count >= cows) return true;
        }

        return false;
    }

    // Binary search to maximize minimum distance
    public static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;

        System.out.println("Maximum minimum distance: " + aggressiveCows(stalls, cows));
    }
}

//Time Complexity (TC): O(n log(max - min)) : Binary search on answer range, each check takes O(n), plus sorting.

//Space Complexity (SC): O(1) : Only a few variables used, no extra data structures.