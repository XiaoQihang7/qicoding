package easy.Dynamic;

import java.util.Arrays;

//补给马车
public class LCP72mache {
    public static void main(String[] args) {
        LCP72mache lcp72mache = new LCP72mache();
        System.out.println(Arrays.toString(lcp72mache.supplyWagon(new int[]{1, 2, 3, 4, 5})));
    }

    /**
     * 暴力模拟
     * @param supplies 输入数组
     * @return 返回合并数组
     */
    public int[] supplyWagon(int[] supplies) {
        int length = supplies.length; //默认向下取整
        for (int i=0;i<(length+1)/2;i++){ //对于偶数数组是需要n/2次循环来合并一半的数，对于奇数需要n/2+1次循环合并
            int min =Integer.MAX_VALUE; //设置一个初始比较值
            int minIndex = -1; //设置数组下标存放合并的值
            for(int j=0;j<length-1-i;j++){ //数组中存在n个数即比较n-1次
                int merge =supplies[j]+supplies[j+1];
                if(merge < min){
                    min = merge;
                    minIndex = j;
                }
            }
            //每一次数组遍历找到合并最小值后，进行数组合并移位
            supplies[minIndex]=min;
            //在合并的地方向前移一位，拷贝的数组长度=每次合并后原数组长度（length-1-i）-拷贝开始的长度(minIndex+1)
            System.arraycopy(supplies,minIndex+1+1,supplies,minIndex+1,length-1-i-minIndex-1);
        }
        return Arrays.copyOf(supplies,length/2); //还好这只是求相邻合并的最小值，要是求不相邻最小值如何解？
    }
}
