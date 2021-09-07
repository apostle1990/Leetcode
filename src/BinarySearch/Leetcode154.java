package BinarySearch;

public class Leetcode154 {
    public static int findMin(int[] nums) {
        int high = nums.length-1;
        int low =0;
        while (low < high){
            int mid = (low  + high)/2;
            if (nums[mid] < nums[high]){
                high = mid;
            } else if (nums[mid] > nums[high]){
                low = mid + 1;
            }else {
                high--;
            }
        }
        return nums[low];
    }
}
