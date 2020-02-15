package leetcode.BFS_DFS;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-12 21:10
 *  102. 二叉树的层次遍历
 **/

public class LevelOrder {
    public List<List<Integer>> levels=new ArrayList<>();
    //广度优先
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize=queue.size();
            ArrayList<Integer> tmp=new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();
                tmp.add(curNode.val);
                if (curNode.left!=null){
                    queue.add(curNode.left);
                }
                if (curNode.right!=null){
                    queue.add(curNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    //深度优先
    public List<List<Integer>> levelOrder_1(TreeNode root){
        if (root==null){
            return levels;
        }
        dfs(root,0);
        return levels;
    }

    public void dfs(TreeNode root, int level){
        if (levels.size()==level){
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(root.val);

        if (root.left!=null){
            dfs(root.left,level+1);
        }
        if (root.right!=null){
            dfs(root.right,level+1);
        }
    }
}
