package chapter13;

public class Leetcode152 {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int max = nums[0];
        int min = nums[0];
        int re = nums[0];
        for (int i=1;i<nums.length;i++){
            int mx = max,mn = min;
            max = Math.max(mx * nums[i],Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i],Math.min(nums[i], mx * nums[i]));
            re = Math.max(re,max);
        }
        return re;
    }

    public static void main(String[] args) {
        Leetcode152 leetcode152 = new Leetcode152();
        int[] nums = {-4,-3,-2};
        int re = leetcode152.maxProduct(nums);
        System.out.println(re);
    }
}
