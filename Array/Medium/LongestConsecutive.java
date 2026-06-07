import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int longest = 1;

        Set<Integer> st = new HashSet<>();

        // Add all elements to the set
        for (int num : nums) {
            st.add(num);
        }

        // Find longest consecutive sequence
        for (int it : st) {

            // Check if it's the start of a sequence
            if (!st.contains(it - 1)) {

                int cnt = 1;
                int x = it;

                while (st.contains(x + 1)) {
                    x++;
                    cnt++;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}

// Time Complexity: O(n), where n is the number of elements in the array. This is because we traverse each element once to build the set and then again to find the longest consecutive sequence.

// Space Complexity: O(n), as we use a set to store the unique elements of the array, which in the worst case can be equal to the size of the input array.