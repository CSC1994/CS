package leetcode.BFS_DFS;

import javafx.util.Pair;
import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-13 14:43
 *  二叉树的最大最小深度
 **/

public class MaxDepth {

    //递归
    public int maxDepth(TreeNode root){
        return root==null?0: 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //非递归
    public int maxDepth_1(TreeNode root){
        Queue<Pair<TreeNode, Integer>> stack=new LinkedList<>();
        if (root!=null){
            stack.add(new Pair<>(root,1));
        }
        int depth=0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> curNode = stack.poll();
            root=curNode.getKey();
            int cur_depth=curNode.getValue();
            if (root!=null){
                depth=Math.max(depth,cur_depth);
                stack.add(new Pair<>(root.left,cur_depth+1));
                stack.add(new Pair<>(root.right,cur_depth+1));
            }
        }
        return depth;
    }

    public int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right =minDepth(root.right);
        return (left==0 || right==0)?left+right+1:1+Math.min(left,right);
    }
}
