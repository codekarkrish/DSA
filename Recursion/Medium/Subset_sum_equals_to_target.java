
import java.util.*;

public class Subset_sum_equals_to_target {

    // Function to check if subset with given target sum exists
    public static boolean isSubsetSum(int[] arr, int target) {

        int n = arr.length;

        boolean[][] dp = new boolean[n][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // First element initialization
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {

            for (int sum = 1; sum <= target; sum++) {

                boolean notTake = dp[i - 1][sum];

                boolean take = false;
                if (arr[i] <= sum) {
                    take = dp[i - 1][sum - arr[i]];
                }

                dp[i][sum] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean result = isSubsetSum(arr, target);

        if (result) {
            System.out.println("Subset with target sum exists.");
        } else {
            System.out.println("Subset with target sum does not exist.");
        }

        sc.close();
    }
}