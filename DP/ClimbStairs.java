package leetcode.DP;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-14 19:10
 * 70. 爬楼梯
 **/

public class ClimbStairs {
    public int climbStairs(int n){
        if (n<=2) return n;
        int one=1;
        int two=1;
        int all=0;
        for (int i = 2; i <= n; i++) {
            all=one+two;
            one=two;
            two=all;
        }
        return all;
    }
}
