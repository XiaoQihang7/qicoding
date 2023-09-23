package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *LeetCode104、树的最大深度
 */
public class maxDepth_104 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9),
                new TreeNode(20,new TreeNode(15),new TreeNode(7)));

        System.out.println(new maxDepth_104().maxDepth1(treeNode));
    }

    /**
     * 解法一：递归
     * @param root 树
     * @return 返回深度
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }

    /**
     * 解法二：队列
     * @param root 树
     * @return 返回深度
     */
    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode treeNode = queue.poll();//如果为空，poll返回为空(队列)，pop抛出异常（栈）
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}



