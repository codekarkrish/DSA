import java.util.*;

public class Max_Consecutive_Ones {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};

        int ans = findMaxConsecutiveOnes(nums);

        System.out.println("The maximum consecutive 1's are " + ans);
    }
}

/*
Algorithm:
1. Initialize count = 0 and maxCount = 0.
2. Traverse the array.
3. If current element is 1, increment count.
4. If current element is 0, reset count to 0.
5. Update maxCount with the maximum of maxCount and count.
6. Return maxCount.

Time Complexity: O(N)
Space Complexity: O(1)
*/