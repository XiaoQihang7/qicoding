package medium.Tree;

public class SubStructure {

    /**
     *offer26\树的子结构
     * @param A 父树
     * @param B 子结构
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //如果A、B初始为null返回false
        //否则如果B是A带根节点的子树返回ture
        //或者B是A的左子树返回true
        //或者B是A的右子树返回true
        //否则返回false
        return (A!=null && B!=null)&& (recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b==null) return true;
        if (a==null||a.val!=b.val) return false;
        //b不为null，且a不为null，a、b当前值相等，进入左子节点和右子节点的比较
        return recur(a.left,b.left)&&recur(a.right,b.right);
    }
}
