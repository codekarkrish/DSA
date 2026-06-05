import java.util.*;

// Class containing majority element logic
public class MajorityElement {

    // Function to find the majority element
    public int majorityElement(int[] nums) {

        // Array size
        int n = nums.length;

        // Count variable
        int cnt = 0;

        // Candidate element
        int el = 0;

        // Moore's Voting Algorithm
        for (int i = 0; i < n; i++) {

            // Agar count 0 ho gaya to naya candidate choose karo
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            }

            // Same element mila to count badhao
            else if (el == nums[i]) {
                cnt++;
            }

            // Different element mila to count ghatao
            else {
                cnt--;
            }
        }

        // Verify karo ki candidate majority element hai ya nahi
        int cnt1 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }

        // Majority element check
        if (cnt1 > n / 2) {
            return el;
        }

        // Majority element nahi mila
        return -1;
    }

    // Driver code
    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        // Object creation
        MajorityElement sol = new MajorityElement();

        int ans = sol.majorityElement(arr);

        System.out.println("The majority element is: " + ans);
    }
}