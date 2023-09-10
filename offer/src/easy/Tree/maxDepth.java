package easy.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * offer55、二叉树的深度（后续遍历、层次遍历）
 */
public class maxDepth {
    public static void main(String[] args) {

    }

    //dfs
    public int lastDfs(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(lastDfs(root.left),lastDfs(root.right))+1;
    }


    //层次遍历，dfs,用队列实现
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>(), tmp;
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
