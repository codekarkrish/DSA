import java.util.*;

public class Maximum_Sum_Combination {

    static class Solution {

        public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int n = nums1.length;

            // Max Heap -> {sum, i, j}
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

            // Stores visited index pairs
            HashSet<String> visited = new HashSet<>();

            // Insert largest possible sum
            pq.offer(new int[]{nums1[n - 1] + nums2[n - 1], n - 1, n - 1});
            visited.add((n - 1) + "," + (n - 1));

            int[] ans = new int[k];
            int idx = 0;

            while (idx < k && !pq.isEmpty()) {

                int[] cur = pq.poll();

                int sum = cur[0];
                int i = cur[1];
                int j = cur[2];

                ans[idx++] = sum;

                // Move left
                if (i - 1 >= 0) {
                    String key = (i - 1) + "," + j;

                    if (!visited.contains(key)) {
                        pq.offer(new int[]{
                                nums1[i - 1] + nums2[j],
                                i - 1,
                                j
                        });
                        visited.add(key);
                    }
                }

                // Move up
                if (j - 1 >= 0) {
                    String key = i + "," + (j - 1);

                    if (!visited.contains(key)) {
                        pq.offer(new int[]{
                                nums1[i] + nums2[j - 1],
                                i,
                                j - 1
                        });
                        visited.add(key);
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums1 = {7, 3};
        int[] nums2 = {1, 6};
        int k = 2;

        int[] ans = obj.maxSumCombinations(nums1, nums2, k);

        System.out.println(Arrays.toString(ans));
    }
}