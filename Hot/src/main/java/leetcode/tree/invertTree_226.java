package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/9/20 11:28
 * 翻转二叉树，并返回根节点
 */
public class invertTree_226 {
    /**
     * 解法一：队列
     *
     * @param root 根节点
     * @return 返回根节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //1、交换并压入队列
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
    /**
     * 解法二：递归
     *
     * @param root 根节点
     * @return 返回根节点
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        //交换
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        //递归
        invertTree1(root.right);
        invertTree1(root.left);
        return root;
    }


}
