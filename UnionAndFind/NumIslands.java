package leetcode.UnionAndFind;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 19:16
 **/

public class NumIslands {
    //坐标
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int m, n;
    char[][] grid;
//    int count = 0;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        visited=new boolean[m][n];
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = floodfill_DFS(i, j);
                res+=count;
            }
        }
        return res;
    }

    //DFS遍历
    private int floodfill_DFS(int x, int y) {
        if (!is_valid(x, y)) {
            return 0;
        }
        grid[x][y] = '0';
//        visited[x][y]=true;
        //递归进行
        for (int i = 0; i < 4; i++) {
            floodfill_DFS(x + dx[i], y + dy[i]);
        }
        return 1;
    }

    private boolean is_valid(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        if (grid[x][y] == '0') {
            return false;
        }
        return true;
    }
}
