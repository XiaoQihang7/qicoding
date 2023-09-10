package medium.Tree;

import java.util.LinkedList;
import java.util.List;

public class pathSumTree {


    /**
     * offer34、二叉树中和为某一值的路径（路径为从根节点到叶子节点）
     *
     * 思路：先序遍历树，计算目标值=目标值-遍历到的值=0？是否为叶子节点？返回该路径：继续回溯遍历  ： 继续回溯
     *
     * @param root
     * @param sum
     * @return
     */

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root , int sum){
        recur(root,sum);
        return res;
    }

    private void recur(TreeNode root, int sum) {
        if(root==null) return;
        path.add(root.val);
        sum-=root.val;
        if (sum==0&&root.left==null&&root.right==null){
            res.add(new LinkedList<>(path));
        }
        recur(root.left,sum);
        recur(root.right,sum);
        path.removeLast();
    }
}
