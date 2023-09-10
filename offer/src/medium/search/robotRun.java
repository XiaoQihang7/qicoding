package medium.search;

import java.util.LinkedList;
import java.util.Queue;

//offer13、机器人的运动范围
public class robotRun {

    public static void main(String[] args) {
        robotRun robotRun = new robotRun();
        System.out.println(robotRun.movingCountBfs(16, 8, 4));//15
        System.out.println(robotRun.movingCountBfs(38, 15, 9));//135
    }

    int m,n,k;
    boolean[][] visited;

    /**
     *
     * BFS：深度优先遍历
     *
     * @param m 行
     * @param n 列
     * @param k 数位和
     * @return
     */
    public int movingCount(int m, int n, int k) {
        this.m=m;this.n=n;this.k=k;
        this.visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }

    private int dfs(int i, int i1, int i2, int i3) {
        if (i>=m||i1>=n||i2+i3>k||visited[i][i1]) return 0;
        visited[i][i1]=true;
        return 1+dfs(i+1,i1,(i2+1)%10!=0 ? i2+1 : i2-8,i3) //向下遍历
                +dfs(i,i1+1,i2,(i3+1)%10!=0 ? i3+1 : i3-8); //向右遍历
    }


    /**
     * BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。
     * DFS 是朝一个方向走到底，再回退，以此类推；BFS 则是按照“平推”的方式向前搜索。
     * BFS 实现： 通常利用【队列】实现广度优先遍历。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCountBfs(int m , int n , int k){
        boolean[][] visited = new boolean[m][n];
        int res=0;
        Queue<int[]> ints = new LinkedList<>();
        ints.add(new int[]{0,0,0,0});
        while (!ints.isEmpty()){
            int[] in = ints.poll();
            int i=in[0],j=in[1],si=in[2],sj=in[3];
            if (i>=m||j>=n||(si+sj)>k|| visited[i][j]) continue;
            visited[i][j]=true;
            res++;
            ints.add(new int[]{i+1,j,(i+1)%10!=0 ? si+1 : si-8,sj});
            ints.add(new int[]{i,j+1,si,(j+1)%10!=0 ? sj+1 : sj-8});
        }
        return res;
    }

    public int movingCountDfs(int m , int n , int k){
        this.m=m;this.n=n;this.k=k;
        visited = new boolean[m][n];
        return MyDfs(0,0,0,0);
    }

    private int MyDfs(int i, int j, int si, int sj) {
        if (i>=m||j>=n||si+sj>k||visited[i][j]) return 0;
        visited[i][j]=true;
        return 1+MyDfs(i+1,j,sums(i+1),sums(j))+MyDfs(i,j+1,sums(i),sums(j+1));
    }


    /** 数位和计算
     *x⊙10 ：得到x 的个位数字；
     *x//10 ： 令 x 的十进制数向右移动一位，即删除个位数字
     * @param x
     * @return
     *
     */
    int sums(int x) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }
}

