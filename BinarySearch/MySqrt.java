package leetcode.BinarySearch;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-13 21:16
 **/

public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int i = mySqrt.mySqrt(8);
        System.out.println(i);
//        System.out.println(8/3);
        System.out.println("===================");
        double v = mySqrt.mySqrt(4, 0.00000000000000001);
        System.out.println(v);
    }
    public int mySqrt(int x){
        if (x==0 || x==1) return x;
        int l=1;
        int r=x;
        int res=0;
        while (l<=r){
            int m=(l+r)/2;
            if (m ==x/m){
                return m;
            }else if (m>x/m){
                r=m-1;
            }else {
                l=m+1;
                res=m;
            }
        }
        return res;
    }

    //牛顿法
    public double mySqrt(int x, double e){
        if(x==0 || x==1) return x;
        double m=x;
        while (true){
            m=(m+x/m)/2.0;
            if (Math.abs(m-x/m)<e){
                return m;
            }
        }
    }
}
