package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-14 19:36
 * 120. 三角形最小路径和
 **/

public class MinimumTotal {
    public static void main(String[] args) {

//        List<Integer> l = Arrays.asList([1],[2,3],);
//        System.out.println(l);
        String s1 = new StringBuilder("GO").append("TO").toString();
        System.out.println(s1.intern()==s1);
        System.out.println(Math.round(-10.5));
    }
    public int minimumTotal(List<List<Integer>> triangle){
        List<Integer> mini=new ArrayList<>(triangle.get(triangle.size()-1).size());
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            mini.add(i,triangle.get(triangle.size()-1).get(i));
        }
        for (int i = triangle.size()-2; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mini.set(j, triangle.get(i).get(j)+Math.min(mini.get(j),mini.get(j+1)));
            }
        }
        return mini.get(0);
    }

    public int miniTotal(List<List<Integer>> triangle){
        if (triangle==null || triangle.size()==0) return 0;
        //多一行，最底层位0
        int[] res=new int[triangle.get(triangle.size()-1).size()+1];
        for (int i = triangle.size()-1; i >=0 ; i--) {
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j < curRow.size(); j++) {
                res[j]=curRow.get(j)+Math.min(res[j],res[j+1]);
            }
        }
        return res[0];
    }

    int row;
    //递归实现
    public int miniTotalRec(List<List<Integer>> triangle){
        row=triangle.size()-1;
        return dfs(0,0,triangle);
    }

    private int dfs(int level, int col, List<List<Integer>> triangle){
        if (level==row){
            return triangle.get(level).get(col);
        }
        int left=dfs(level+1,col,triangle);
        int right=dfs(level+1,col+1,triangle);
        return Math.min(left,right)+triangle.get(level).get(col);
    }
}
