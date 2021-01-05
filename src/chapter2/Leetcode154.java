package chapter2;

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

    public static void main(String[] args) {
        int[] nums={10,1,10,10,10};
        int[] nums1={4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
