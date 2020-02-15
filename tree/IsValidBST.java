package leetcode.tree;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-12 17:18
 *  78、验证是否为二叉搜索树
 **/

public class IsValidBST {
    double last=-Double.MAX_VALUE;
    //递归判断前序节点小于后续节点
    public boolean isValidBST_1(TreeNode root){
        if (root==null){
            return true;
        }
        if (isValidBST_1(root.left)){
            if (last<root.val){
                last = (double)root.val;
                return isValidBST_1(root.right);
            }
        }
        return false;
    }

    public boolean isValidBST_2(TreeNode root){
        return isValidBST_2(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST_2(TreeNode root, long min, long max){
        if (root==null){
            return true;
        }
        if (root.val<=min || root.val >=max){
            return false;
        }
        return isValidBST_2(root.left, min, root.val) && isValidBST_2(root.right,root.val,max);
    }
}
