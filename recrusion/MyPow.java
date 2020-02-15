package leetcode.recrusion;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-12 19:18
 * 50. Pow(x, n)
 **/

public class MyPow {

    public static void main(String[] args) {
        System.out.println(5/2);
    }
    //问题：栈溢出
    public double myPow(double x, int n){
        if (n==0){
            return 1;
        }
        if (n<0){
            return 1/myPow(x,-n);
        }
        if (n%2!=0){
            return x*myPow(x,n-1);
        }
        return myPow(x*x,n/2);
    }

    public double myPow_2(double x,int n){
        double res=1.0;
        for (int i = n; i !=0 ; i/=2) {
            if (i%2!=0){
                res *=x;
            }
            x*=x;
        }
        return n<0? 1/res:res;
    }
}
