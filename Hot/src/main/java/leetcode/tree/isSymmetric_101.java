package leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/9/22 9:07
 */
public class isSymmetric_101 {

    /**
     * 解法一：队列+迭代
     * @return 返回是否对称
     */
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root.left);
        treeNodes.offer(root.right);
        while (!treeNodes.isEmpty()) {
            TreeNode lef = treeNodes.poll();
            TreeNode rig = treeNodes.poll();

            if (lef == null && rig == null) {
//                return true;//大忌
                continue;
            }
            if (lef == null || rig ==null){
                return false;
            }
            if (lef.val != rig.val){
                return false;
            }
            treeNodes.offer(lef.left);
            treeNodes.offer(rig.right);
            treeNodes.offer(lef.right);
            treeNodes.offer(rig.left);
        }
        return true;
    }

        /**
         * 解法二：递归
         * @return 返回是否对称
         */
        public boolean isSymmetric1(TreeNode root){
            //效率!
            if (root == null){
                return true;
            }
            //递归检测(左右检测)
            return deepCheck(root.left,root.right);
        }

        private boolean deepCheck(TreeNode left, TreeNode right) {
            if (left == null && right ==null){
                return true;
            }
            if (left == null ||right ==null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            return deepCheck(left.left,right.right) && deepCheck(left.right,right.left);
        }
}
