package medium.search;

public class matrixExist {
    /**
     *offer12、矩阵中的路径
     *
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.length() == 0) return true;

        int m = board.length, n = board[0].length;
        char[] c = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //这里不能直接return dfs 因为如果返回false，
                //只是代表当前格子不行，还要继续寻找
                if (dfs(board, c, i, j, 0)) return true;
            }
        }
        //没找到，返回false
        return false;
    }

    /**
     * 深度优先搜索
     * i，j是当前所在格子，idx是当前遍历到word的第几个字符了
     */
    private boolean dfs(char[][] board, char[] word, int i, int j, int idx) {
        //递归终止:越界 or 当前字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[idx]) return false;

        if (idx == word.length - 1) return true;//到结尾说明找到了

        char tmp = board[i][j]; //提前记录下来，方便回溯时候修改回来
        board[i][j] = '-'; //标记已访问

        //向上下左右搜索
        boolean res = dfs(board, word, i - 1, j, idx + 1) ||
                dfs(board, word, i + 1, j, idx + 1) ||
                dfs(board, word, i, j - 1, idx + 1) ||
                dfs(board, word, i, j + 1, idx + 1);

        board[i][j] = tmp; //回溯，修改回来，表示未访问过

        return res;
    }
}
