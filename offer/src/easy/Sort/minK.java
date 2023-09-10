package easy.Sort;

import java.util.Arrays;
import java.util.stream.IntStream;

//offer40、最小的k个数
public class minK {

    public static void main(String[] args) {
        minK minK = new minK();
        long s1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(minK.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        long e1 = System.currentTimeMillis();
        System.out.println(e1-s1);
        long s2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(minK.getLeastNumbers1(new int[]{0, 1, 2, 1}, 1)));
//        System.out.println(Arrays.toString(minK.getLeastNumbers2(new int[]{0, 1, 2, 1}, 1)));
        long e2 = System.currentTimeMillis();
        System.out.println(e2 - s2);
    }

    //直接调用stream流的api
    public int[] getLeastNumbers(int[] arr, int k) {
        IntStream sorted = Arrays.stream(arr).sorted();
        int[] ints = sorted.toArray();
        return Arrays.copyOf(ints,k);
    }

    //快排
    public int[] getLeastNumbers1(int[] arr, int k) {
        int len = arr.length-1;
        if (k>len) return arr;
        return quickSort1(arr,k,0,arr.length - 1);
    }

    private int[] quickSort1(int[] arr, int k, int l, int r) {
        int i=l,j=r;
        while (i<j){
            while (i<j&&arr[j]>=arr[l]) j--;
            while (i<j&&arr[i]<=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        if (i > k) return quickSort(arr,k,l,i-1);
        if (i < k) return quickSort(arr,k,i+1,r);
        return Arrays.copyOf(arr,k);
    }

    private int[] quickSort2(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
//
//    private void swap(int[] arr, int i, int j) {
//        int tmp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=tmp;
//    }



    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }
    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
