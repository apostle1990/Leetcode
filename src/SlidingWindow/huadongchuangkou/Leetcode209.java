package SlidingWindow.huadongchuangkou;

public class Leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
        int min = nums.length;
        int sum = 0;
        int right = 0;
        int left = 0;
        boolean change = false;
        while (true){
            if (sum<s){
                sum = sum + nums[right];
                right++;
            }else {
                sum = sum - nums[left];
                left++;
            }
            if (sum >= s){
                change = true;
                min = Math.min(min,right-left);
            }
            if (right==nums.length && sum<s){
                if (!change) min=0;
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int s = 15;
        int[] nums = {1,2,3,4,5};
        Leetcode209 leetcode209 = new Leetcode209();
        int min = leetcode209.minSubArrayLen(s,nums);
        System.out.println(min);
    }
}
