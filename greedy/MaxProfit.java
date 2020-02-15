package leetcode.greedy;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-12 20:31
 *  122. 买卖股票的最佳时机 II
 **/

public class MaxProfit {
    public int maxProfit(int[] prices){
        int res=0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i]<prices[i+1])
                res+=prices[i+1]-prices[i];
        }
        return res;
    }
}
