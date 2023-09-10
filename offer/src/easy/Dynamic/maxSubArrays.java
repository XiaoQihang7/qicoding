package easy.Dynamic;

//offer42、连续子数组的最大和
public class maxSubArrays {

    /**
     *
     * 动态规划解决

     * @param nums 输入数组
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int i:nums){
            pre=Math.max(pre+i,i);//比较当前数与当前数+下一数的和，谁大返回谁
            maxAns=Math.max(maxAns,pre);//要是第一个数/上一次比较的数最大，则返回这个数
        }

        return maxAns;
    }

    //也可使用分治
}
