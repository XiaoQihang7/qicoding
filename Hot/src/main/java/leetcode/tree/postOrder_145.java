package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的后序遍历
public class postOrder_145 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new postOrder_145().postorderTraversal1(treeNode));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //递归
        ArrayList<Integer> res = new ArrayList<>();
        pRecursion(root , res);
        return res;
    }
    private void pRecursion(TreeNode root , ArrayList<Integer> res){
        if (root == null) return;
        pRecursion(root.left , res);
        pRecursion(root.right , res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root){
        //栈+迭代
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode preAccess = null;
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();

            if(node.right == null || node.right == preAccess){ //preAccess用于打破死循环(防止遍历过的右节点继续遍历)
                res.add(node.val);
                preAccess = node;
            }else{
                //压栈
                stack.push(node);
                root = node.right;
            }
        }
        return res;
    }
}
