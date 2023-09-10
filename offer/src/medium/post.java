package medium;

import java.util.*;

/**
 * 基于迭代的二叉树遍历
 */
public class post {

    //后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //prev用来标记上一次右子树是否已经访问过
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        /*退出循环的条件，root != null没有特殊含义，只是让循环得以进行下去，
        循环的终止条件只要是判断栈空不空所决定*/
        while (root != null || !stack.isEmpty())
        {
            while (root != null)    //左链入栈
            {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();  //左子树为空将根节点出栈
            res.add(node.val);
            root = node.right;   //访问右子树

        }
        return res;
    }

    //先序遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tree=stack.pop();//先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if(tree.right!=null)
                stack.push(tree.right);
            if(tree.left!=null)
                stack.push(tree.left);
            res.add(tree.val);
        }
        return res;
    }


}
