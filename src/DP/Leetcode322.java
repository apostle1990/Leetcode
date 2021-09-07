package DP;

import java.util.Arrays;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount +1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i=1; i<=amount;i++){
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        Leetcode322 leetcode322 = new Leetcode322();
        int res = leetcode322.coinChange(coins, amount);
        System.out.println(res);
    }
}
