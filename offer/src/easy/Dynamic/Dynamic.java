package easy.Dynamic;

import java.util.HashMap;

//动态规划
public class Dynamic {
    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();
        System.out.println(dynamic.fib(4));
        System.out.println(dynamic.fib(50));
    }

    HashMap<Integer, Integer> integers = new HashMap<>();

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        // if(n<2){
        //     return n;
        // }
        // return fib(n-1)+fib(n-2); 使用递归超时

        /*递归+记忆搜索*/
        integers.put(0,0);
        integers.put(1,1);
        System.out.println(integers.containsKey(n));
        System.out.println(integers.toString());
        System.out.println(1000000008 % 1000000007);
        if (n<2){
            return n;
        }else {
            int re = f(n);
//            integers.put(n,re);
            System.out.println(integers.toString());
            return re;
        }
    }
    int f(int n){
        if (integers.containsKey(n)){
            return integers.get(n);
        }
        int r=(f(n-1)+f(n-2))%1000000007;
        integers.put(n,r);
       return r;
    }

    //找规律循环求和（动态规划）
    public int fib2(int n) {
        if(n<=1)return n;

        int a = 0;
        int b = 1;
        int sum = 0;

        for(int i = 2;i<=n;i++){
            sum = (a + b) % 1000000007;
            a=b;
            b=sum;
        }
        return sum;
    }
}
