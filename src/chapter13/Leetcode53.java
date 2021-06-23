package chapter13;

//最大子序和
public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);
        int max = dp[0];
        for (int i=1;i<dp.length;i++){
            dp[i] = Math.max(dp[i],dp[i]+dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] nums = {-1,-2};
        int re = leetcode53.maxSubArray(nums);
        System.out.println(re);
    }
}
