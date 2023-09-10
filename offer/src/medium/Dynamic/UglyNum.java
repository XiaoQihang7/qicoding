package medium.Dynamic;

public class UglyNum {

    /**
     *offer49、丑数
     *只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * （1是丑数）
     *
     *
     * 解题思路：1、找到丑数，2、由于存储丑数是从0到n存储，故存入数组即可
     * 找丑数：丑数=较小丑数*丑数因子，如5=1*5,4=2*2,8=4*2,1=1*1
     * 每一个丑数都是有基础丑数相乘得出,即从小到大，都可由已有丑数推出
     *
     * @param n 第n个丑数
     * @return
     */
    public int nthUglyNumber(int n) {
        /**
         * 每一个丑数都是有基础丑数相乘得出,即从小到大，都可由已有丑数推出
         * 找丑数：丑数=较小丑数*丑数因子 （指向较小丑数的指针，用过之后指针后移）
         */
        //已知1为最小丑数
        int[] dp = new int[n];
        dp[0]=1;
        int a=0,b=0,c=0;
        for (int i=1;i<n;i++){
            int n1=dp[a]*2,n2=dp[b]*3,n3=dp[c]*5;
            dp[i]= Math.min(n1,Math.min(n2,n3));
            if (dp[i]==n1) a++; //找到了2或2的倍数，指针后移
            if (dp[i]==n2) b++;
            if (dp[i]==n3) c++;
        }
        return dp[n-1];
    }
}
