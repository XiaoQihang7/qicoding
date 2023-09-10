package easy.Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntUnaryOperator;

public class mirrorTreeD {

    /**
     * Offer27、二叉树的镜像
     * 对于需要遍历树而后输出树对象的情况，使用递归较好（递归可以很好的向下查找）
     *
     * @param root
     * @return
     */

    //死胡同，想不出了❌
    public TreeNode mirrorTree(TreeNode root){
        TreeNode treeNode = new TreeNode(root.val);
        TreeNode tCun = new TreeNode(root.val);
        TreeNode tCun1 = null;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            treeNode=node;         //需要等值覆盖，向下查找，由于覆盖了之前的值，下次这个树又是一个新树
            if (node.right!=null) {
                queue.add(node.right);
                treeNode.left=node.right;
                tCun.left=treeNode;
            }
            if (node.left!=null) {
                queue.add(node.left);
                treeNode.right=node.left;
                tCun.right=treeNode;
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        mirrorTreeD mirrorTreeD = new mirrorTreeD();
        //[4,2,7,1,3,6,9]
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(9);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode2.left=treeNode5;
        treeNode2.right=treeNode6;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        System.out.println(mirrorTreeD.mirrorTree1(treeNode));
    }

    //递归+回溯返回结果
    public TreeNode mirrorTree1(TreeNode root){
        if (root==null){
          return null;
        }
//        TreeNode treeNode = new TreeNode(root.val);
//        treeNode.right=mirrorTree1(root.left);
//        treeNode.left=mirrorTree1(root.right);
//        return treeNode;
        return recur(root);
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


