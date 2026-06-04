import java.util.*;

class Find_Missing_and_Repeating_Element {

    public int[] findMissingRepeatingNumbers(int[] nums) {

        long n = nums.length;

        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0, S2 = 0;

        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * nums[i];
        }

        long val1 = S - SN;      // X - Y
        long val2 = S2 - S2N;    // X² - Y²

        val2 = val2 / val1;      // X + Y

        long x = (val1 + val2) / 2; // Repeating
        long y = x - val1;          // Missing

        return new int[]{(int)x, (int)y};
    }
}

public class Main {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        Find_Missing_and_Repeating_Element sol =
                new Find_Missing_and_Repeating_Element();

        int[] result = sol.findMissingRepeatingNumbers(nums);

        System.out.println(
            "Repeating = " + result[0] +
            ", Missing = " + result[1]
        );
    }
}