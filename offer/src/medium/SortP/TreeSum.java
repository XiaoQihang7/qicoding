package medium.SortP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {

    /**
     *三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> treeSumm(int[] nums){
        //排序后使用双指针定位就可以便捷的去除重复元素了
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length-2 ; i++){
            if (nums[i]>0) break; //排序后第一个值都大于0则没有满足条件的值
            if(i>0 && nums[i] == nums[i-1]) continue; //防止第一个值重复
            int j = i+1, k = nums.length-1;

            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum<0){
                    while(j < k && nums[j] == nums[++j]);
                }else if (sum>0){
                    while (j<k && nums[k] == nums[--k]);
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (j<k && nums[j] == nums[++j]); //防止后两个值重复
                    while (j<k && nums[k] == nums[--k]);
                }
            }
        }
        return res;
    }
}
