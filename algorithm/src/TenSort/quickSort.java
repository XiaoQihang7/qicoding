package TenSort;

import java.util.*;

/**
 * 快速排序
 *
 * 调bug过程： ①、通读程序 ②、输出中间值 ③、剪功能，逐渐调试丰富功能
 */
public class quickSort {

    public static void main(String[] args) {
         int[] arr ={7,3,3,8,2,8,1,8,9,5,4,6};
         sort(arr,0,arr.length-1);

//        quickSortD(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        List<int[]> ints = Collections.singletonList(arr);
        System.out.println(ints);
        HashSet<Integer> integers = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        integers.add(1);
        integers.addAll(list);
        integers.add(3);
        integers.add(8);
        integers.add(2);
        integers.add(4);
        System.out.println(integers); //无序，但每次输出固定
    }


    /**
     * 老韩的快排，以中间值为基准值
     * @param arr
     * @param leftBound
     * @param rightBound
     */
    public static void sort(int[] arr , int leftBound , int rightBound){
        int l = leftBound , r =rightBound;
        int pivot = arr[(leftBound+rightBound)/2];
        while(l < r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l >= r) break;
            swap(arr, l, r);
            if (arr[l] == pivot) l++;
            if (arr[r] == pivot) r--;
            if (r == l) { //方便退出循环
                r--;
                l++;
            }
            if (leftBound < r) sort(arr, leftBound, r);
            if (rightBound > l) sort(arr, l, rightBound);
        }
    }

    /**
     * 马士兵的单轴快排
     * @param arr
     * @param leftBound
     * @param rightBound
     */
    public static void quickSortD(int[] arr,int leftBound , int rightBound){
        if (leftBound>=rightBound) return;
        int mid = partition(arr,leftBound,rightBound);
        quickSortD(arr,leftBound,mid-1);
        quickSortD(arr,mid,rightBound);
    }

    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound ,right =rightBound-1;
        while (left <= right){ //不加=，栈溢出
            while(left<=right && arr[left] <= pivot) left++; //第一个条件加等于防止数组越界
            while (left<=right && arr[right] > pivot) right--; //这里第二个条件不写=是防止有多个分区值导致排序异常
            if (left < right)
                swap(arr,left,right);
        }
        swap(arr ,left ,rightBound);
        return left;
    }

    static void swap(int[] arr,int i, int j){
        int temp =arr[i];
        arr[i] = arr [j];
        arr[j] =temp;
    }


}
