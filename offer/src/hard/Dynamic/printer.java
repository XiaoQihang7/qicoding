package hard.Dynamic;

import java.util.Arrays;

public class printer {
    public int strangePrinter(String s){
        int n = s.length();
        char[] chars = s.toCharArray();
        int [][] dp = new int[n][n];
//        for (int i = 0;i < n; i++)
//        Arrays.fill(dp[i],0x3f3f3f3f); //将数组值填充为“最大值”
        int minn = Integer.MAX_VALUE; //优化，提升性能

        for (int i = n-1 ; i >= 0 ; i--){ //行
            dp[i][i]=1; //将当前遍历到的仅打印字符设为1

            for(int j = i+1 ; j < n ; j++){ // 往后遍历 给列赋值
                if(chars[i]==chars[j]) dp[i][j] = dp[i][j-1]; //遍历到的第一个字符与后需字符相等，直接赋原值（前一个值）
                else
                    for (int k = i ; k < j ;k++){
//                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]); //不相等则进行完整字符枚举
                        minn = Math.min(minn,dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j]=minn;
            }

        }

        return dp[0][n-1];
    }
}
