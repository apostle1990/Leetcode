package chapter2;

public class Leetcode410 {
    public static int splitArray(int[] nums, int m) {
        int left =0,right =0;
        for (int i=0;i < nums.length;i++){
            right += nums[i];
            if (left < nums[i]){
                left = nums[i];
            }
        }
        while (left < right){
            int mid = left + (right - left) /2;
            if (check(nums,mid,m)){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;
    }
    public static boolean check(int[] nums, int x, int m){
        int sum = 0;
        int cnt = 1;
        for (int num : nums) {
            if (sum + num > x) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums,m));
    }
}
