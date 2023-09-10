package medium.Dynamic;

public class giftValue {
    public static void main(String[] args) {

    }

    /**
     *offer47、礼物的最大值
     *
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     *你可以从棋盘的【左上角开始】拿格子里的礼物，并每次【向右或者向下移动一格】、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     * 这题我的疑惑是，每一步都可以选择右和下，路径有很多，那怎么归纳总的最大值呢？
     *
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int row=grid.length-1,col=grid[0].length-1;
        for (int i=1;i<=row;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for (int j=1;j<=col;j++){
            grid[0][j]+=grid[0][j-1];
        }
        for (int i=1;i<=row;i++)
            for (int j=1;j<=col;j++)
                grid[i][j]+= Math.max(grid[i][j-1],grid[i-1][j]);
        return grid[row][col];
    }
}
