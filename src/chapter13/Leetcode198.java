package chapter13;

import chapter12.Leetcode529;

public class Leetcode198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i=2; i<len;i++){
            int num2 = dp[i-2];
            if (i-3>=0) num2 = Math.max(num2,dp[i-3]);
            dp[i] = num2 + nums[i];
        }
        return Math.max(dp[len-2], dp[len - 1]);
    }

    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        int[] nums = {1,2,3,1};
        int res = leetcode198.rob(nums);
        System.out.println(res);
    }
}
