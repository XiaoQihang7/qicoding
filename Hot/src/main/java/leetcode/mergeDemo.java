package leetcode;

import java.util.Arrays;

/**
 * LeetCode_88、合并两个有序数组
 */
public class mergeDemo {
    public static void main(String[] args) {
        mergeDemo mergeDemo = new mergeDemo();
        mergeDemo.merge(new int[]{1,2,6,0,0,0},3,new int[]{1,3,5},3);
    }

    /**
     * 解法一：jdk负重前行
     * @param nums1 大数组
     * @param m 大数组个数
     * @param nums2 小数组
     * @param n 小数组个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0 ; i<n ; i++){
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 解法二：双指针 (利用两数组递增机制，以及给定的大数组，无需再引入额外的空间)
     * @param nums1 大数组
     * @param m 大数组个数
     * @param nums2 小数组
     * @param n 小数组个数
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int l = nums1.length-1 , ind1 = m-1 , ind2 = n-1 ; l >= 0 ;  l--){
            if (ind1 < 0){
                nums1[l] = nums2[ind2--];
            }
            else if (ind2 < 0){
                nums1[l] = nums1[ind1--];
            }
            else if (nums1[ind1] > nums2[ind2]){
                nums1[l] = nums1[ind1--];
            }else{
                nums1[l] = nums2[ind2--];
            }
        }
    }
}
