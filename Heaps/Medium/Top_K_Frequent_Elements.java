import java.util.*;

public class Top_K_Frequent_Elements {

    static class Solution {

        public int[] topKFrequent(int[] nums, int k) {

            // Count frequency of each element
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Bucket sort based on frequency
            List<Integer>[] bucket = new ArrayList[nums.length + 1];

            for (int key : map.keySet()) {
                int freq = map.get(key);

                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }

                bucket[freq].add(key);
            }

            int[] ans = new int[k];
            int index = 0;

            // Collect top k frequent elements
            for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
                if (bucket[i] != null) {
                    for (int num : bucket[i]) {
                        ans[index++] = num;
                        if (index == k) {
                            break;
                        }
                    }
                }
            }

            return ans;
        }
    }

    // Driver Code
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        Solution obj = new Solution();
        int[] result = obj.topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}

// Time Complexity: O(N)
// Reason: Frequency counting O(N), bucket filling O(N), bucket traversal O(N).

// Space Complexity: O(N)
// Reason: HashMap and bucket array together store at most N elements.