package leetcode.DP;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-15 18:01
 * leetcode股票系列：121、122、123、188、309、714
 **/

public class MaxProfit {
    /**
     * 状态转移方程：
     * 第i天第k次交易不持有股票：要么前一天没有股票；要么前一天持有股票，第i天卖了
     * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1]+p[i])
     * 第i天第k次交易持有股票：要么前一天持有股票不动；要么前一天不持有股票，第i天买进。
     * 注意：这里将交易次数计算在买进时
     * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0]-p[i])
     *
     * 基本状态：
     * dp[-1][k][0]=0   天数为负，不持有股票
     * dp[-1][k][1]=-inf    天数为负，持有股票，不可能
     * dp[i][0][0]=0    交易次数为0，不持股票
     * dp[i][0][1]=-Inf 交易次数为0，持有股票，不可能
     */

    /**
     * 只允许交易一次
     * 1、k=1
     *
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        //二维数组
/*        int n = nums.length;
        if (n <= 0) return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if ((i - 1) == -1) {
                dp[i][0] = 0;//第一天不持有股票
                dp[i][1] = -nums[i];//第一天持有股票
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -nums[i]);
        }
        return dp[n - 1][0];*/

        //继续优化成一维数组
        int n = prices.length;
        if (n <= 0) return 0;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    //2、k为正无穷，即不限交易次数，退化成k次和k-1次交易一样
    public int maxProfit_inf(int[] prices) {
        /** k为正无穷，k与k-1一致
         * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1]+p[i])
         * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0]-p[i]
         *              =max(dp[i-1][k][1], dp[i-1][k][0]-p[i])
         */
        int n = prices.length;
        if (n <= 0) return 0;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }

    //3、k为正无穷，且有cooldown限制
    public int maxProfit_inf_cooldown(int[] prices) {
        /**
         * k为正无穷，且有cooldown限制
         * dp[i][0]=max(dp[i-1][0], dp[i-1][1]+p[i])
         * dp[i][1]=max(dp[i-1][1], dp[i-2][0]-p[i])    提前两天
         */
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre = 0; //代表dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre - prices[i]);
            dp_pre = tmp;
        }
        return dp_i_0;
    }

    //4、k为正无穷，且有交易费
    public int maxProfit_inf_fee(int[] prices, int fee) {
        /**
         * dp[i][0]=max(dp[i-1][0], dp[i-1][1]+p[i])
         * dp[i][1]=max(dp[i-1][1],dp[i-1][0]-p[i]-fee)
         */
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }
        return dp_i_0;
    }

    //5、k=2
    public int maxProfit_2(int[] prices) {
        /**
         * dp[i][k][0]=max(dp[i-1][k][0], dp[i-1][k][1]+p[i])
         * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0]-p[i])
         */
/*        int n = prices.length;
        int K = 2;
        int[][][] dp = new int[n][K+1][2];
        for (int i = 0; i < n; i++) {
            for (int k = K; k >= 1; k--) {
                if ((i - 1) == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                if ((k - 1) == 0) {
                    dp[i][k-1][0] = 0;
                    dp[i][k-1][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n-1][K-1][0];*/

        int n = prices.length;
//        int K=2;
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int p : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + p);
            dp_i21 = Math.max(dp_i21, dp_i10 - p);
            dp_i10 = Math.max(dp_i10, dp_i11 + p);
            dp_i11 = Math.max(dp_i11, -p);
        }
        return dp_i20;
    }

    //k=任意数
    public int maxProfit_kAny(int[] prices, int max_k) {
        int n = prices.length;
        if (max_k > n / 2) {
            return maxProfit_inf(prices);
        }

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
//            dp[i][0][0]=0;
            dp[i][0][1]=Integer.MIN_VALUE;
        }
        for (int i = 0; i <= max_k; i++) {
            dp[0][i][1]=Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
