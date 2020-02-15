package leetcode.BFS_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-13 15:27
 * 22. 括号生成
 **/

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(2);
        System.out.println(list);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generateOneByOne("",res,n,n);
        return res;
    }

    /**
     * 递归辅助函数
     *
     * @param sublist：拼接子串
     * @param res：最终结果
     * @param left：左括号还未使用的
     * @param right：右括号还未使用的
     */
    public void generateOneByOne(String sublist, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sublist);
            return;
        }
        if (left > 0) {
            generateOneByOne(sublist + "(", res, left - 1, right);
        }
        if (left < right && right > 0) {
            generateOneByOne(sublist + ")", res, left, right - 1);
        }
    }
}
