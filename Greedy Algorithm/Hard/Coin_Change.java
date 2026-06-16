import java.util.*;

public class Coin_Change {

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int) 1e9);

        dp[0] = 0;

        for (int coin : coins) {
            for (int target = coin; target <= amount; target++) {
                dp[target] = Math.min(dp[target], 1 + dp[target - coin]);
            }
        }

        return dp[amount] >= 1e9 ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);

        System.out.println("Minimum coins needed: " + result);
    }
}