import java.util.*;

public class Distinct_Numbers_in_Each_Subarray {

    public static List<Integer> distinctNumbers(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans.add(freq.size());

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            int remove = nums[i - k];
            freq.put(remove, freq.get(remove) - 1);

            if (freq.get(remove) == 0) {
                freq.remove(remove);
            }

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            ans.add(freq.size());
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 2, 1, 3};
        int k1 = 3;
        System.out.println(distinctNumbers(nums1, k1)); // [3, 2, 2, 2, 3]

        int[] nums2 = {1, 1, 1, 1, 2, 3, 4};
        int k2 = 4;
        System.out.println(distinctNumbers(nums2, k2)); // [1, 2, 3, 4]
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(min(n, k))
*/