package TenSort;

import java.util.Arrays;

/**
 * 归并排序 （分而治之 ， 先分后治）
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {1,4,7,8,88,86,4,5,66,3,6,9};
        int[] temp = new int[arr.length];
        new mergeSort().mSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(arr));
    }
    //将数据分为，按照中间值前后按顺序排列的数据
    public void mSort(int[] arr , int left , int right , int[] temp){
        if (left >= right) return;
        int mid = left + (right-left)/2; //小tips : 防止left+right超出int范围
        mSort(arr , left ,mid ,temp);
        mSort(arr , mid+1 ,right ,temp);

        //治：合并
        merge(arr,left,mid,right,temp);
    }

    public void merge(int[] arr , int left , int mid , int right , int[] temp ){
        int l = left , j = mid+1 , t = 0; //由于拷贝时需要使用到left和mid，所有要对这个变量进行保存
//        int[] temp = new int[right-left+1];

        while (l <= mid && j <= right){
//            if (arr[l] <= arr[j]) {
//                temp[t] = arr[l];
//                l++;
//                t++;
//                temp[t] = arr[j];
//                t++;
//                j++;
//            }
            temp[t++] = arr[l]<=arr[j] ? arr[l++] : arr[j++]; //简写
        }
        //如果一边遍历完成之后，将另一边直接加入数组（因为两边的数据都是有序的）
        while (l<=mid) temp[t++] = arr [l++];
        while (j<=right) temp[t++] = arr[j++];

        //将temp中的数据拷贝到arr中去
        t=0;
        int templeft = left;
        while (templeft <= right){
            arr[templeft++] = temp[t++];
        }
    }
}
