package DP;

import java.util.Arrays;

public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        int max = target+1;
        int[] dp = new int[max];
        dp[0] = 1;
        for (int i=1;i<max;i++){
            for (int num:nums){
                if (num<=i){
                    dp[i] += dp[i-num];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }

    public static void main(String[] args) {
        Leetcode377 leetcode377 = new Leetcode377();
        int[] nums = {1,2,3};
        int target = 4;
        int res = leetcode377.combinationSum4(nums,target);
        System.out.println(res);
    }
}
