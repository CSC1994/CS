package leetcode.UnionAndFind;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 17:50
 **/

public class QuickUnionUF {
    private int[] roots;

    public QuickUnionUF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        //优化部分，将节点都指向根节点
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q){
        int proot=findRoot(p);
        int qroot=findRoot(q);
        roots[proot]=qroot;
    }
}
