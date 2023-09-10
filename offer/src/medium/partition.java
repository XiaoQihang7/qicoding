package medium;


import java.util.HashMap;

/**
 * 分治算法
 */
public class partition {

    public static void main(String[] args) {
        int[] preorder =new int[]{3,9,20,15,7};
        int[] inorder =new int[]{9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));//直接输出是调用toString方法的

    }


    /**
     * offer07 重建二叉树
     *
     * @param preorder 先序遍历数组
     * @param inorder 中序遍历数组
     * @return
     */
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //定位inorder中根节点所在位置
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return recur(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private static TreeNode recur(int[] preorder, int[] inorder, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        //创建根节点
        TreeNode treeRoot = new TreeNode(preorder[root]);
        //定位中序数组中根所在的位置
        int rootIndex = hashMap.get(preorder[root]);
        //左子树的大小
        int left_size=rootIndex-left;

        //构建左子树
        treeRoot.left=recur(preorder,inorder,root+1,left,rootIndex-1);
        //构建右子树,需要找到新一次构建右子树的根节点（即上一次构建的根节点下标+左子树+1）
        treeRoot.right=recur(preorder,inorder,root+left_size+1,rootIndex+1,right);//"根"是去先序数组中找值的

        return treeRoot;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
