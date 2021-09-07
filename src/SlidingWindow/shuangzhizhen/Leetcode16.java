package SlidingWindow.shuangzhizhen;

import java.util.Arrays;

public class Leetcode16 {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int minsum = 3000;
            if (nums == null || nums.length<3){
                int sum=0;
                for (int i:nums) sum = sum + i;
                return sum;
            }
            Arrays.sort(nums);
            for (int i=0;i<nums.length-2;i++){
                int left = i + 1,right = nums.length-1;
                while(left<right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum-target)<Math.abs(minsum-target)) minsum = sum;
                    if (sum<target) left++;
                    else if (sum==target) return sum;
                    else right--;
                }
            }
            return minsum;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,2};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums,target));
    }
}
