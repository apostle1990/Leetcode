package chapter13;

import java.util.Arrays;

public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        Arrays.fill(dp[m-1],1);
        for (int i=m-2;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (j==n-1){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        for (int[] row:dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int m=3,n=7;
        Leetcode62 leetcode62 = new Leetcode62();
        int res = leetcode62.uniquePaths(m,n);
        System.out.println(res);
    }
}
