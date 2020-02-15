package leetcode.bit;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-14 16:40
 * 231. 2的幂
 **/

public class IsPowerOfTwo {
    public static void main(String[] args) {
        int m=3&2;
        System.out.println(m);
    }
    public boolean isPowerOfTwo(int n){
        if (n<0) return false;
        int flag=n&(n-1);
        if (n!=0 && flag==0){
            return true;
        }
        return false;
    }
}
