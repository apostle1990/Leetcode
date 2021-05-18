package chapter13;

import java.util.Arrays;

public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (i == m-1 && j == n-1){
                    continue;
                }
                if (j==n-1){
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                    continue;
                }
                if (i == m-1){
                    dp[i][j] = dp[i][j+1] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
            }
        }
        for (int[] row:dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        Leetcode64 leetcode64 = new Leetcode64();
        int res = leetcode64.minPathSum(grid);
        System.out.println(res);
    }
}
