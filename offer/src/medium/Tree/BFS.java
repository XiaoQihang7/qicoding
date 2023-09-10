package medium.Tree;

import java.util.*;

//剑指offer32 从上到下打印二叉树
public class BFS {
    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList<>(0);
        ArrayList<List<Integer>> listss = new ArrayList<>();
        Deque<Object> objects = new LinkedList<>();
        objects.add(111);//头
        objects.add(222);
        objects.add(333);//尾
        System.out.println(Arrays.toString(objects.toArray()));
        System.out.println(Objects.equals(objects.peekFirst(), objects.peek())); //pollFirst与poll值相同地址不同
        System.out.println(objects.pollLast());

        System.out.println("0 % 2"+"="+0 % 2);
        System.out.println(lists);
        System.out.println(listss);

        BFS bfs = new BFS();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
//[1,2,3,4,null,null,5]
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;
        System.out.println(new ArrayList<Integer>(treeNode1.val));//null
        System.out.println(bfs.levelOrder2(treeNode1));
        System.out.println(bfs.levelOrder3(treeNode1));
    }
    /**
     * 二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
     * BFS 通常借助 队列 的先入先出特性来实现。
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        //使用先入先出的队列完成树的遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //使用一个List存储节点
        ArrayList<Integer> arrayList = new ArrayList<>();
        //遍历获取树节点
        while (!queue.isEmpty()) {
            TreeNode firstNode = queue.poll();
            arrayList.add(firstNode.val);
            if (firstNode.left != null) {
                queue.add(firstNode.left);
            }
            if (firstNode.right != null) {
                queue.add(firstNode.right);
            }
        }
//        int[] result = new int[arrayList.size()];
//        for (int i = 0; i < arrayList.size(); i++) {
//            result[i] = arrayList.get(i);
//        }
        return arrayList.stream().mapToInt(x -> x).toArray();//使用stream流慢2ms且多占用0.4mb的内存
    }

    /**
     * 从上到下打印二叉树，每一层存入一个list
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> cun = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        if(root == null){
            return cun;
        }
        qu.add(root);
        while (!qu.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode treeNode=null;
            int size = qu.size();
            for (int i=0;i<size;i++) {
                treeNode = qu.poll();
                if (treeNode.left != null) {
                    qu.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    qu.add(treeNode.right);
                }
                list.add(treeNode.val);
            }
            cun.add(list);
        }
        return cun;
    }

    /**
     * 按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> cun = new ArrayList<>();
        Deque<TreeNode> qu = new LinkedList<>();

        if(root == null){
            return cun;
        }
        qu.add(root);
        int count=0;
        while (!qu.isEmpty()){
            Deque<Integer> list = new LinkedList<>();
            TreeNode treeNode;
            int size = qu.size();
            count++;
//            for (int i=0;i<size;i++) { 这样会出现一个问题，即取出哪个节点就以此为节点向后遍历
//                if (count%2==0){
//                    treeNode=qu.pollFirst();//Deque才有的方法
//                }else {
//                    treeNode = qu.pollLast();
//                }
//                if (count%2!=0) { //根据队列先进先出原理：开始先存入右节点再存左节点，取出时也就先取右再取左
//                    if (treeNode.left != null) {
//                        qu.addFirst(treeNode.left);
//                    }
//                    if (treeNode.right != null) {
//                        qu.addFirst(treeNode.right);
//                    }
//                }else {
//                    if (treeNode.left != null) {
//                        qu.add(treeNode.left);
//                    }
//                    if (treeNode.right != null) {
//                        qu.add(treeNode.right);
//                    }
//                }
//                list.add(treeNode.val);
//            }

            //存入list时再进行整理，不能影响树的遍历顺序；只是输出顺序适当变化
            for (int i=0;i<size;i++){
                treeNode = qu.poll();
                //如何存？偶数则倒序存
                if (count%2==0){
                    list.offerFirst(treeNode.val);
                }else list.offer(treeNode.val);
                if (treeNode.left != null) {
                    qu.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    qu.add(treeNode.right);
                }
            }
            cun.add(new LinkedList<>(list));
        }
        return cun;
    }
}
