package chapter13;

import java.util.Arrays;

public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (i == m-1 && j == n-1){
                    dp[m-1][n-1] = 1;
                    continue;
                }
                if (obstacleGrid[i][j]==1){
                    dp[i][j] =0;
                    continue;
                }
                if (j==n-1){
                    dp[i][j] = dp[i+1][j];
                    continue;
                }
                if (i == m-1){
                    dp[i][j] = dp[i][j+1];
                    continue;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        Leetcode63 leetcode63 = new Leetcode63();
        int res = leetcode63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
