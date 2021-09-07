package BinarySearch;

public class Leetcode287 {
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left =1, right = len-1;
        while (left < right){
            int mid = left + (right - left) /2;
            int cnt =0;
            for (int num : nums){
                if (num <= mid){
                    cnt +=1;
                }
            }
            if (cnt > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
