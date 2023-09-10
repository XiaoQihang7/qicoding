package leetcode;

import java.util.Arrays;

/**
 * LeetCode_283、移动零
 */
public class moveZeroesDemo {

    public static void main(String[] args) {
        moveZeroesDemo moveZeroesDemo = new moveZeroesDemo();
        moveZeroesDemo.moveZeroes(new int[]{1,0,5,4,0,8});
    }

    /**
     * 双指针+移动
     * @param nums
     */
    public void moveZeroes(int[] nums){
        int i = 0 ;
        int j = 0 ;
        for (; i<nums.length ; i++ ){
            if (nums[i] != 0){
//                if (nums[i] == nums[j]){
//                    j++;
//                    continue;
//                }
                nums[j++] = nums[i];
            }
        }

        for (; j<nums.length ; j++){
            nums[j] = 0;
            System.out.println(Arrays.toString(nums));
        }
    }
}
