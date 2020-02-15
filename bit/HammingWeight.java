package leetcode.bit;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-14 16:32
 *  191. 位1的个数
 **/

public class HammingWeight {
    public int hammingWeight(int n){
        int res=0;
        while (n!=0){
            res++;
            n=n&(n-1);
        }
        return res;
    }
}
