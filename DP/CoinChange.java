package leetcode.DP;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 15:52
 * 322. 零钱兑换
 **/

public class CoinChange {

    /**
     * 1、状态：dp[i]代表在i时所需最小的硬币数
     * 2、方程：dp[i]=min(dp[i-coins[k]])+1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}
