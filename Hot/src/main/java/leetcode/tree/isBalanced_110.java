package leetcode.tree;

import java.sql.Ref;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/9/20 9:43
 * 平衡二叉树
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class isBalanced_110 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5, null, null))
                , new TreeNode(3, new TreeNode(6), null));
        System.out.println(new isBalanced_110().isBalanced(treeNode));
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        return bRecursionMax(root)!=-1;
    }

    private int bRecursionMax(TreeNode node) {
        if (node == null){
            return 0;
        }
        int left = bRecursionMax(node.left);
        int right = bRecursionMax(node.right);

        if (left == -1 || right == -1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

}
