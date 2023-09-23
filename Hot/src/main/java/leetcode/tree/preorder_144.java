package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的前序遍历
public class preorder_144 {
    /**
     * 解法一：递归
     * @param root 根节点
     * @return 返回结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        iRecursion(root,res);
        return res;
    }

    private void iRecursion(TreeNode root, ArrayList<Integer> res) {
        //递归存放
        if (root == null){
            return;
        }
        res.add(root.val);
        iRecursion(root.left , res);
        iRecursion(root.right , res);
    }

    /**
     * 解法二：迭代+栈
     * @param root 根节点
     * @return 返回结果
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> treeNodes = new LinkedList<>();
        while (root != null || !treeNodes.isEmpty()){
            while (root != null){
                res.add(root.val);
                treeNodes.push(root);
                root = root.left;
            }
            TreeNode pop = treeNodes.pop();
            root = pop.right;
        }
        return res;
    }
}
