package chapter13;

public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k==0) {
            return 0;
        }
        int[][] dp = new int[k+1][2];
        for (int i=2;i<=k;i++){
            dp[i][1] = Integer.MIN_VALUE;
        }
        dp[1][1] = -prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            dp[1][1] = Math.max(dp[1][1], -prices[i]);
            dp[1][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);
            max = dp[1][0];
            for (int j=2;j<=k;j++){
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                max = Math.max(dp[j][0],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode188 leetcode188 = new Leetcode188();
        int k = 2;
        int[] price = {3,2,6,5,0,3};
        int res = leetcode188.maxProfit(k,price);
        System.out.println(res);
    }
}
