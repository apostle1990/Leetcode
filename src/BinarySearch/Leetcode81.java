package BinarySearch;

public class Leetcode81 {
    public static boolean search(int[] nums, int target) {
        int n= nums.length;
        if (n==0) return false;
        if (n==1) return nums[0] == target;
        int left =0 , right = n-1;
        while (left <= right){
            int mid = (left +right)/2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }
            if (nums[left]<nums[mid]){
                if (nums[left]<=target && target<nums[mid]){
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            }else {
                if (target>nums[mid] && target<=nums[right]){
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
        }
        return false;
    }
}
