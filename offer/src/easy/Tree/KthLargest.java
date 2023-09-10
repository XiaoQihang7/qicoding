package easy.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * offer54、二叉搜索树的第k大节点
 */
public class KthLargest {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);
    }
    List tar = new ArrayList<Integer>();
    public int kthLargestNum(TreeNode root , int k){
        dfs(root);
        return (int) tar.get(tar.size()-k);
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        tar.add(root.val);
        dfs(root.right);
    }
}
