package leetcode.tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的中序遍历
public class inorderTraversal_94 {

    /**
     * 解法一：递归
     * @param root 根节点
     * @return 返回中序遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        iRecursion(root,res);
        return res;
    }

    private void iRecursion(TreeNode root, ArrayList<Integer> res) {
        //递归存放
        if (root == null){
            return;
        }
        iRecursion(root.left , res);
        res.add(root.val);
        iRecursion(root.right , res);
    }

    /**
     * 解法二：栈+迭代
     * @param root 根节点
     * @return 返回中序遍历结果
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        //双循环
        Deque<TreeNode> deque = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
//        deque.push(root);
        while (root!=null || !deque.isEmpty()){
//            TreeNode node = deque.pop();
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            TreeNode treeNode = deque.pop();
            list.add(treeNode.val); //空指针异常
            root = treeNode.right;
        }
        return list;
    }

}
