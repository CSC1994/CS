package leetcode.UnionAndFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-16 20:19
 **/

public class NumIslands_BFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int r = grid.length;
        int c = grid[0].length;
        int res = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * c + j);//二维数组转换成一维
                    while (!queue.isEmpty()) {
                        int val = queue.remove();
                        //还原行和列
                        int row = val / c;
                        int col = val % c;
                        //开始遍历
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add((row - 1) * c + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < r && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * c + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(row * c + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < c && grid[row][col + 1] == '1') {
                            queue.add(row * c + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}
