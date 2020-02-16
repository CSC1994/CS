package leetcode.DP;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 17:10
 **/

public class MinDistance {
    /**
     * 1、状态
     *      dp[i][j] w1的前i个字符和w2的前j个字符相同匹配最小的步数
     * 2、方程
     *      if w1[i]==w2[j]  dp[i][j]=dp[i-1][j-1]  不用处理
     *      否则，进行insert, delete, replace三种操作
     *      对应：dp[i-1][j], dp[i][j-1], dp[i-1][j-1]三者最小的数+1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (w1[i-1] == w2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int tmp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    int min = Math.min(tmp, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[m][n];
    }
}
