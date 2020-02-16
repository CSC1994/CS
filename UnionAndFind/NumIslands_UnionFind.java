package leetcode.UnionAndFind;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 20:54
 **/

public class NumIslands_UnionFind {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * c + j, (i - 1) * c + j);
                    }
                    if (i + 1 < r && grid[i + 1][j] == '1') {
                        unionFind.union(i * c + j, (i + 1) * c + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * c + j, i * c + j - 1);
                    }
                    if (j + 1 < c && grid[i][j + 1] == '1') {
                        unionFind.union(i * c + j, i * c + j + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }
}

class UnionFind {
    int count;//起始连接的数量
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count++;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    //找根节点
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    //连接
    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        if (proot != qroot) {
            if (rank[proot] < rank[qroot]) {
                parent[proot] = qroot;
            } else if (rank[proot] > rank[qroot]) {
                parent[qroot] = proot;
            } else {
                parent[proot] = qroot;
                rank[qroot]+=1;
            }
            count--;
        }
    }

    //得到联通数
    public int getCount() {
        return count;
    }
}
