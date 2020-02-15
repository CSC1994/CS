package leetcode.DP;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-15 15:28
 * 152. 乘积最大子序列
 **/

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {-2, -1};
        MaxProduct maxProduct = new MaxProduct();
        int i = maxProduct.maxProduct(nums);
        System.out.println(i);
    }

    //暴力遍历
    public int maxProduct(int[] nums) {
        int tmp = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tmp = nums[i];
            if (tmp > res) {
                res = tmp;
            }
            for (int j = i + 1; j < nums.length; j++) {
                tmp *= nums[j];
                if (tmp > res) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public int maxProduct_1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }
}
