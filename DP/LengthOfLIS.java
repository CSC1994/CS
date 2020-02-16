package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 14:53
 * 300. 最长上升子序列
 **/

public class LengthOfLIS {
    //dp时间复杂度n^2
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //优化O(NlgN)----------------待完善
/*    public int LIS(int[] nums){
        if (nums==null || nums.length==0){
            return 0;
        }
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(lis, nums[i]);
            if (index==-1){

            }
        }
    }

    private static int binarySearch(List<Integer> list, int target){
        if (list==null){
            return -1;
        }
        int left=0;
        int right=list.size();
        while (left<=right){
            int mid=(left+right)/2;
            if (list.get(mid)==target){
                return mid;
            }else if (list.get(mid)<target){
                right=mid;
            }else {
                left=mid;
            }
        }
        return -1;
    }*/
}
