import java.util.*;

class Solution {

    public int findDuplicate(int[] nums) {

        // Slow aur Fast pointer ko same position se start kar rahe hain
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Cycle ke andar meeting point find karo
        do {

            // Slow 1 step move karega
            slow = nums[slow];

            // Fast 2 step move karega
            fast = nums[nums[fast]];

        } while (slow != fast);

        // Slow ko starting point par wapas le jao
        slow = nums[0];

        // Phase 2: Cycle ka entrance (duplicate number) find karo
        while (slow != fast) {

            // Dono pointers ko 1-1 step move karo
            slow = nums[slow];
            fast = nums[fast];
        }

        // Jahan dono dubara milte hain wahi duplicate number hai
        return slow;
    }
}

public class Find_the_Duplicate_Number {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        Solution obj = new Solution();

        int duplicate = obj.findDuplicate(nums);

        System.out.println("Duplicate Number: " + duplicate);
    }
}