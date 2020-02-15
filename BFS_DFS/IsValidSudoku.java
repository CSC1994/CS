package leetcode.BFS_DFS;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-13 19:53
 * 36. 有效的数独  37
 **/

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board){
        if (board==null || board.length==0){
            return false;
        }
        boolean res = dfs(board);
        return res;
    }

    private boolean dfs(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='.'){
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)){
                            board[i][j]=c;
                            if (dfs(board)){
                                return true;
                            }else {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i <9; i++) {
            if (board[row][i] !='.' && board[row][i]==c){
                return false;
            }
            if (board[i][col]!='.' && board[i][col]==c){
                return false;
            }
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]!='.' && board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }
        }
        return true;
    }
}
