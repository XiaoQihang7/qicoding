package leetcode;

import java.util.HashMap;

/**
 * LeetCode_1、两数之和
 */
public class twoSumDemo {
    public static void main(String[] args) {
        twoSumDemo twoSumDemo = new twoSumDemo();
    }

    /**
     * 解法一：暴力穷举 （双指针，遍历查询）O(n^2)
     * @param nums 目标数组
     * @param target 目标值
     * @return 返回数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int n = 0 ; n < nums.length ; n++){
            for (int i = n+1 ; i < nums.length ; i++){
                if (nums[n] + nums[i] == target){
                    result[0] = n ;
                    result[1] = i ;
                }
            }
        }
        return result;
    }

    /**
     * 解法二：穷举+map (使用map存储已遍历的数据+下标，减少重复遍历)这也称为记忆搜索 O(n)
     * @param nums 目标数组
     * @param target 目标值
     * @return 返回数组下标
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n = 0 ; n < nums.length ; n++){
            //设计规则（即需要什么，后续存入什么）
            int r = target - nums[n];
            if (map.containsKey(r)){
                result[0] = map.get(r);
                result[1] = n;
                break;
            }else {
                map.put(nums[n],n);
            }
        }
        return result;
    }




}
