import java.util.*;

public class LongestSubarryWithSumK {

    public int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // Subarray from index 0 to i has sum k
            if (sum == k) {
                maxLen = i + 1;
            }

            // Check if (sum - k) occurred before
            int rem = sum - k;

            if (map.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - map.get(rem));
            }

            // Store first occurrence of prefix sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;

        LongestSubarryWithSumK obj = new LongestSubarryWithSumK();

        int ans = obj.longestSubarray(nums, k);

        System.out.println("Length of longest subarray = " + ans);
    }
}