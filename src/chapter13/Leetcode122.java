package chapter13;

public class Leetcode122 {
    //动态规划
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2) return 0;
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i=1; i<len; i++){
            dp[0] = Math.max(dp[0],dp[1]+prices[i]);
            dp[1] = Math.max(dp[1],dp[0]-prices[i]);
        }
        return dp[0];
    }

    //贪心算法
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len<2) return 0;

        int res = 0;
        for (int i=1; i<len; i++){
            res += Math.max(prices[i] - prices[i-1],0);
        }
        return res;
    }
}
