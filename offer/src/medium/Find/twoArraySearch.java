package medium.Find;

import java.util.Arrays;

public class twoArraySearch {

    public static void main(String[] args) {
        twoArraySearch twoArraySearch = new twoArraySearch();
        int[][] ints= new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        int[][] ins=new int [][]{{3,3,8,13,13,18},{4,5,11,13,18,20},{9,9,14,15,23,23},
        {13,18,19,20,25,27},{18,22,23,28,30,33},{21,25,28,30,35,35},{24,25,33,36,37,40}};

        int[][] in=new int [][]{{3,6,9,12,17,22},{5,11,11,16,22,26},{10,11,14,16,24,31},
                {10,15,17,17,29,31},{14,17,20,23,34,37},{19,21,22,28,37,40},{22,22,24,32,37,43}};

        int[][] a =new int[2][3];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                a[i][j]=j+i;
            }
        }
        System.out.println(Arrays.deepToString(a));

        System.out.println(Arrays.deepToString(new int[][]{{}}));
        System.out.println(twoArraySearch.findNumberIn2DArray(new int[][]{{-4,-3},{-2,1}},-4));
        System.out.println(twoArraySearch.findNumberIn2DArray(ins,21));
    }

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
     * 每一列都按照从上到下 非递减 的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param matrix
     * @return
     */
    //从中间开始找，会出现一个致命问题，不知道是从上往下找还是从下往上找（做题前思路要清晰明确[观察仔细！    ]，有体系）
    public boolean findNumberIn2DArray(int[][] matrix,int target) {
        //从[matrix.length/2][matrix[i].length-1],从中间行最右侧开始查找
        if (matrix.length==0){
            return false;
        }
        int size=matrix.length/2,count=0;
        int len=matrix[size].length-1;
        for (int j=0;j<matrix.length;j++) {
             for (int i = 0; i <= matrix[size].length; i++) {
                if (size>matrix.length-1) return false;
                if (len>matrix[size].length-1||len<0) return false;
                else if (size==0&&matrix[0][len]<target) {
//                    if (count!=0){
                     size = matrix.length - 1;
//                    }else size++;
                     if (size > matrix.length - 1) return false;
                 }
                else if (target>matrix[size][len]&&len<matrix[size].length-1||target < matrix[size][len] && len == 0) {
//                    target > matrix[size][len]&&len==0||
                    size--;
                    count++;
                    if (size>matrix.length-1||size<0) return false;
                    len=matrix[size].length-1;
                    if (target==matrix[size][len]) return true;
                }
                else if (target > matrix[size][len])  {
                    if (count>0){
                        size=size+count+1;
                        count=Integer.MIN_VALUE;
                    }else if (count<0){
                        size=matrix.length-1;
                    } else size++;
                    if (size>matrix.length-1) return false;
                }
                else if (target < matrix[size][len]) {
                    len--;
                    if (len>matrix[size].length-1||len<0) return false;
                }
                else return true;
            }
        }
        return false;
    }

    //z型查找,从第一层尾开始找
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if(matrix.length==0){ //防止[]
            return false;
        }
        int m = matrix.length;
        int x = 0, y = matrix[0].length-1;
        while (x < m && y >= 0) { //设计循环时，就将数组越界解决了
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    //二分查找，每一层以二分查找
    public boolean findNumberIn2DArray3(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
