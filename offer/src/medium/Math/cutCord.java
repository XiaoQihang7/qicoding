package medium.Math;

//Offer14、剪绳子
public class cutCord {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));

    }

    public static int cuttingRope(int n) { //2<=n<=58
        int[] ints = new int[n + 1];  //核心思路：利用数组的特性：将下标对应为绳子长度
        if (n==2){
            return 1;
        }
        for (int p=2;p<=n;p++) {
            int pMax=0;
            for (int i = 1; i < p; i++) {
                pMax=Math.max(pMax,Math.max(i*(p-i),i*ints[p-i]));
            }
            ints[p]=pMax;
        }
        return ints[n];
    }
}
