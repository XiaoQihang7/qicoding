package leetcode;

import java.util.HashMap;

/**
 * LeetCode—70、爬楼梯
 */
public class climbStair {
    public static void main(String[] args) {
        climbStair climbStair = new climbStair();
        System.out.println(climbStair.climbStairs2(4));
    }

    /**
     * 解法一：递归 （自顶向下）有重复计算，每递归到的数可能已经计算过了 [超出时间限制]
     *
     * @param n 楼梯阶层
     * @return 走法
     */
    public int climbStairs(int n) {
        //典型的斐波那契数列的结果 f(n) = f(n-1)+f(n-2)
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 解法二：递归+map （自顶向下）存入计算过的值，避免重复计算
     *
     * @param n 楼梯阶层
     * @return 走法
     */
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int climbStairs1(int n) {
        //典型的斐波那契数列的结果 f(n) = f(n-1)+f(n-2)
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (hashMap.get(n) != null) {
            return hashMap.get(n);
        }
        //疑点：存进map的是数吗？ 存入的是当前阶梯数的走法
        int i = climbStairs1(n - 1) + climbStairs1(n-2);
        hashMap.put(n,i);
        return i ;
    }

    /**
     * 解法三：滚动数列 （自底向上）需要两个变量存入计算过前两个阶层走法的值，重复利用数据
     *
     * @param n 楼梯阶层
     * @return 走法
     */
    public int climbStairs2(int n) {
        //典型的斐波那契数列的结果 f(n) = f(n-1)+f(n-2)
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 2;
        int prePre = 1;
        for ( int r = 3 ;r<=n ;r++){
            //当前走法=f(n-1)+f(n-2) 是函数之和不是单纯的数字之和
            int u = pre;
            pre = pre + prePre;
            prePre = u;
        }
        return pre;
    }

}
