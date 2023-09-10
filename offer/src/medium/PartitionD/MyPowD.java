package medium.PartitionD;

public class MyPowD {

    public static void main(String[] args) {
        MyPowD myPowD = new MyPowD();
        System.out.println(myPowD.powD(2, -10));

    }
    /**
     * offer16\实现pow(x,n)= x^n
     *
     * 快速幂
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;//看二进制数最后一位是否为1，是1则乘上2^(n-1);n为第几位二进制数
            x *= x; //计算出当前数的多少二次幂
            b >>= 1;
        }
        return res;
    }

    //超出时间限制
    public double powD(double a, int b){
        double res=1.0;
//        for (int i=b;i>0;i--){
        if(b < 0) {
            a = 1 / a;
            b = -b;
        }
        int i=b;
        while(i>0){
            i--;
            res=res*a;
        }
        return res;
    }
}
