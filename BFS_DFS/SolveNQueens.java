package leetcode.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-13 16:34
 * 51. N皇后
 **/

public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> res = solveNQueens.solveNQueens(4);
        System.out.println(res);
        System.out.println(res.size());
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        dfs(0,new boolean[n],new boolean[2*n],new boolean[2*n], new String[n],res);
        return res;
    }

    /**
     * 深度递归求解
     *
     * @param r：递归层次，行数
     * @param cols：列标号
     * @param pieFlag：左下角是否可放
     * @param naFlag：右下角是否可放
     * @param board:          每一行棋盘放置情况
     * @param res：结果保存
     */
    private void dfs(int r, boolean[] cols, boolean[] pieFlag, boolean[] naFlag, String[] board, List<List<String>> res) {
        //递归终止条件
        if (r == board.length) {
            res.add(Arrays.asList(board.clone()));
        } else {
            for (int c = 0; c < board.length; c++) {
                int pie = r - c + board.length;
                int na = 2 * board.length - r - c - 1;
                //判断列、撇、捺是否冲突
                if (!cols[c] && !pieFlag[pie] && !naFlag[na]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true;
                    pieFlag[pie] = true;
                    naFlag[na] = true;
                    //继续递归
                    dfs(r + 1, cols, pieFlag, naFlag, board, res);
                    //回退时擦除之前的标记
                    cols[c] = false;
                    pieFlag[pie] = false;
                    naFlag[na] = false;
                }
            }
        }
    }
}
