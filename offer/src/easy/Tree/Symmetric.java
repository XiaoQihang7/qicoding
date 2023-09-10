package easy.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Symmetric {

    public static void main(String[] args) {
//        [1,2,2,null,3,null,3]
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right =treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        Symmetric symmetric = new Symmetric();
        System.out.println(symmetric.isSymmetric(treeNode1));
    }


    /**
     * offer28,对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode rear = recur(root);
//        Deque<TreeNode> nodes = new LinkedList<>();
//        Deque<TreeNode> nodes1 = new LinkedList<>();

        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<TreeNode> nodes1 = new ArrayList<>();
        nodes.add(root);
        nodes1.add(rear);
        System.out.println(nodes);
        System.out.println(nodes1); //虽然节点值一样，但是在队列中是不一样的
        return nodes.equals(nodes1);
//        return equals(root,rear);
    }

    private boolean equals(TreeNode root, TreeNode rear) {
        if (root==null && rear==null){
            return true;
        }
        else if(root==null || rear==null ||root.val != rear.val) return false;
        return equals(root.left,rear.left)&&equals(root.right,rear.right);
    }

    private TreeNode recur(TreeNode root) { //如果是这样的递归，那也是覆盖后向下查找(已改良)
        if (root==null)
        return null;
        TreeNode res = new TreeNode(root.val);
        res.left=recur(root.right);
        res.right=recur(root.left);
        return res;
    }
}

//便捷解法
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}