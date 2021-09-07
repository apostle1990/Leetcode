package DP;

import java.util.Arrays;

public class Leetcode343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i=3;i<=n;i++){
            for (int j =1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max((i-j) *j,j*dp[i-j]));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        int n = 10;
        int res = leetcode343.integerBreak(n);
        System.out.println(res);
    }
}
