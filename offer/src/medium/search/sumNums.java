package medium.search;

/**
 * offer64,求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C
 * 逻辑短路符运算！
 * 比如说 A&&B A错则B不执行
 * A || B  A对则B不执行 ，短路
 */
public class sumNums {
    int res = 0 ;
    public int sums(int n){
        boolean x = n > 0&& sums(n-1)>0;
        res+=n;
        return res;
    }
}
