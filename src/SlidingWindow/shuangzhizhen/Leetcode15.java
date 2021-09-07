package SlidingWindow.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    static class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> allnum = new ArrayList<>();
            if (nums == null || nums.length<3) return allnum;
            Arrays.sort(nums);
            for (int i=0;i< nums.length-2;i++){
                if (nums[i]>0) break;
                if (i >0 && nums[i] == nums[i-1]) continue;
                int target = -nums[i];
                int left = i+1, right = nums.length-1;
                while (left<right){
                    if(nums[left]+nums[right]==target){
                       allnum.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                       left++;right--;
                       while (left<right && nums[left] == nums[left-1]) left++;
                       while (left<right && nums[right] == nums[right+1]) right--;
                    }else if (nums[left] + nums[right] <target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
            return allnum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
    }
}
