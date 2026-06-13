import java.util.*;

public class Three3Sum {

    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {

            // Sort the array
            Arrays.sort(nums);

            // Store all unique triplets
            List<List<Integer>> ans = new ArrayList<>();

            // Fix the first element
            for (int i = 0; i < nums.length; i++) {

                // Skip duplicate first elements
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;

                int left = i + 1;
                int right = nums.length - 1;

                // Two-pointer approach
                while (left < right) {

                    int sum = nums[i] + nums[left] + nums[right];

                    // Triplet found
                    if (sum == 0) {

                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        left++;
                        right--;

                        // Skip duplicate left elements
                        while (left < right && nums[left] == nums[left - 1])
                            left++;

                        // Skip duplicate right elements
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }

                    // Need larger sum
                    else if (sum < 0) {
                        left++;
                    }

                    // Need smaller sum
                    else {
                        right--;
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        Solution obj = new Solution();
        List<List<Integer>> result = obj.threeSum(nums);

        System.out.println("Triplets with sum 0:");

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

/*
Time Complexity: O(NlogN) + O(N²)

Reason:
- O(NlogN) for sorting the array.
- The outer loop runs approximately N times.
- For each i, the left and right pointers together traverse the remaining array at most once.
- Hence the total complexity becomes O(N²).

Overall TC = O(NlogN) + O(N²)

Space Complexity: O(no. of triplets)

Reason:
- Extra space used by the algorithm is O(1).
- Space is only required to store the resulting triplets.

So:
Auxiliary Space = O(1)
Total Space = O(no. of triplets)
*/