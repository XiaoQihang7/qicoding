package easy;

import java.util.Arrays;
import java.util.HashMap;

public class twoNumSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new twoNumSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
    /**
     * 两数之和，非暴力求解，减小时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
