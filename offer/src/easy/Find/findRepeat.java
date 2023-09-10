package easy.Find;

import java.util.*;
import java.util.stream.Collectors;

//Offer03、数组中重复的数字
public class findRepeat {
    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 0, 2, 5, 3};
        List<int[]> ints1 = Arrays.asList(ints);
        long collect = ints1.stream().distinct().count();
        System.out.println(collect);

        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        System.out.println("No. of distinct elements:"+l);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);


        System.out.println(findRepeatNumber(ints));
        System.out.println((search2(new int[]{1},1)));
        TreeSet<Integer> integers = new TreeSet<>();//int基本数据类型不能直接进行排序比较
    }

    public static int findRepeatNumber(int[] nums) {
//        ArrayList<Integer> integers = new ArrayList<>();
        HashSet<Integer> integers = new HashSet<>(); //hashSet比ArrayList速度快
        for (int i : nums) {
            if (!integers.contains(i)) {
                integers.add(i);
            } else return i;
        }
        return -1;
    }

    //原地交换
    public static int findRepeatNumber1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    /**
     * Offer53、在排序数组中查找数字I（数组为非递减数组）
     * @param nums
     * @param target
     * @return
     */
    //暴力查找
    public int search(int[] nums, int target) {
        int count=0;
        for (int num :
                nums) {
            if(num==target) count++;
        }
        return count;
    }

    //二分查找
    public int search1(int[] nums, int target) {
            // 搜索右边界 right
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] <= target) i = m + 1;
                else j = m - 1;
            }
            int right = i;
            // 若数组中无 target ，则提前返回
            if(j >= 0 && nums[j] != target) return 0; //目标值大于中间值，但右区间并没有该值
            // 搜索左边界 left
            i = 0; j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] < target) i = m + 1;
                else j = m - 1;
            }
            int left = j;
            return right - left - 1;
    }

    //二分查找优化,减少重复代码
    public static int search2(int[] nums,int target){
        return find(nums,target)-find(nums,target-1);
    }

    private static int find(int[] nums, int target) {
        int i=0,len=nums.length-1;
        while (i<=len){
            int mid=(i+len)/2;
            if (nums[mid]<=target) i=mid+1;
            else len=mid-1;
        }
        return i; //输出的有边界值为i，防止输入的数组长度为1.
    }
}
