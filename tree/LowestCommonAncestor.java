package leetcode.tree;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-12 17:56
 *  236、二叉树的最近公共祖先
 **/

public class LowestCommonAncestor {

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if (root==null || root==p || root==q){
            return root;
        }
        TreeNode left=LCA(root.left,p,q);
        TreeNode right=LCA(root.right,p,q);
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }
}
