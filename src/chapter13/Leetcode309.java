package chapter13;

public class Leetcode309 {
    //持股冷冻期
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2) return 0;

        int[] dp = new int[3];

        dp[1] = -prices[0];

        int pre0 = dp[0];
        int pre2 = dp[2];

        for (int i=1; i<len; i++){
            dp[0] = Math.max(dp[0],pre2);
            dp[1] = Math.max(dp[1],pre0-prices[i]);
            dp[2] = dp[1] + prices[i];

            pre2 = dp[2];
            pre0 = dp[0];
        }
        return Math.max(dp[0],dp[2]);
    }
}
