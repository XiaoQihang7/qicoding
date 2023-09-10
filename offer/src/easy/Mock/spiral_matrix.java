package easy.Mock;

import java.util.ArrayList;
import java.util.Arrays;

public class spiral_matrix {
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {3, 4, 5}};
        System.out.println(ints[1].length);

        spiral_matrix spiral_matrix = new spiral_matrix();
        System.out.println(Arrays.toString(spiral_matrix.spiralOrder1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));

    }

    /**
     * offer29、顺时针打印矩阵
     *
     * @param matrix
     * @return
     */

    boolean[][] booleans;
    ArrayList<Integer> arrayList;

    //递归且破代码，有bug
    public  int[] spiralOrder(int[][] matrix) {
        booleans = new boolean[matrix.length][matrix[0].length];
        arrayList = new ArrayList<>();
        return recur(matrix,0,0);
    }

    private int[] recur(int[][] matrix, int i, int j) {
        arrayList.add(matrix[i][j]);
        if (!booleans[i][j]&&j<matrix[i].length-1) {
            booleans[i][j]=true;
            recur(matrix,i,++j);
        }
        else if (!booleans[i][j]&&j>=matrix[i].length-1) {
            booleans[i][j]=true;
            recur(matrix,++i,j);
        }
        else if (!booleans[i][j]&&i>=matrix.length-1) {
            booleans[i][j]=true;
            recur(matrix,i,--j);
        } else if (!booleans[i][j] && i <= matrix.length - 1) {
            booleans[i][i] = true;
            recur(matrix,--i,j);
        }
            return arrayList.stream().mapToInt(x->x).toArray();
    }

    //暴力解法
    public int[] spiralOrder1(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}
