package leetcode.bit;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-14 17:25
 **/

public class NQueue {
    public static void main(String[] args) {
        NQueue nQueue = new NQueue();
        int i = nQueue.solveNQueue(8);
        System.out.println(i);
    }

    private int res=0;
    public int solveNQueue(int n){
        if (n<0) return 0;
        dfs(n,0,0,0,0);
        return res;
    }

    private void dfs(int n, int row, int col, int pie, int na){
        //递归返回条件
        if (row>=n){
            res++;
            return;
        }
        //得到当前所有的空位
        int bits=(~(col | pie | na)) & ((1<<n) -1);
        while (bits>0){
            int p=bits& -bits;//取到最低位为1的位置，即可以放皇后的位置
            dfs(n, row+1, col |p, (pie|p)<<1, (na|p)>>1);
            bits&=(bits-1);//去掉最低位的1循环
        }
    }
}
