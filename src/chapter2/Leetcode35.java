package chapter2;

public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int pivot=0,left=0,right=nums.length-1;
        while (left<=right){
            pivot = (right + left)/2;
            if (nums[pivot]==target) return pivot;
            if (nums[pivot] > target) right = pivot-1;
            else left = pivot+1;
        }
        int result = nums[pivot]<target?pivot+1:pivot;
        if (result<0)result=0;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        Leetcode35 leetcode35 = new Leetcode35();
        System.out.println(leetcode35.searchInsert(nums,target));
    }
}
