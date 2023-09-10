package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_448、找到所有数组中消失的数据
 *
 *给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class disappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new disappearedNumbers().findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //思维：充分利用数组下标。
        //找寻1-n范围内没有出现的数字，n为数组长度（下标+1）如果【数组元素值-1】对应的下标的值存在则属于1-n中的数字，以下标作为标识符
        int l = nums.length;
        for (int i = 0 ; i<l ; i++){
//          if ((nums[i]-1)%l - 1 < l){
              nums[(nums[i]-1) % l] +=l;
//          }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i< l ; i++){
            if (nums[i] <= l){
                list.add(i+1);
            }
        }
        return list;
    }
}
