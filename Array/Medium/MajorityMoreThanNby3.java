
import java.util.*;

class MajorityMoreThanNby3 {

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        // Count of candidate 1 and candidate 2
        int cnt1 = 0, cnt2 = 0;

        // Potential majority elements
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // Phase 1: Find the candidates
        for (int i = 0; i < n; i++) {

            // Assign first candidate
            if (cnt1 == 0 && nums[i] != el2) {
                cnt1 = 1;
                el1 = nums[i];
            }

            // Assign second candidate
            else if (cnt2 == 0 && nums[i] != el1) {
                cnt2 = 1;
                el2 = nums[i];
            }

            // Increment count of candidate 1
            else if (nums[i] == el1) {
                cnt1++;
            }

            // Increment count of candidate 2
            else if (nums[i] == el2) {
                cnt2++;
            }

            // Current element matches neither candidate
            // Cancel out one vote from both candidates
            else {
                cnt1--;
                cnt2--;
            }
        }

        // Phase 2: Verify the candidates

        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {

            if (num == el1) {
                cnt1++;
            }

            if (num == el2) {
                cnt2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        int mini = (n / 3) + 1;

        if (cnt1 >= mini) {
            result.add(el1);
        }

        if (cnt2 >= mini && el1 != el2) {
            result.add(el2);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {11, 33, 33, 11, 33, 11,12,12};

        MajorityMoreThanNby3 sol = new MajorityMoreThanNby3();

        List<Integer> ans = sol.majorityElement(arr);

        System.out.println(ans);
    }
}