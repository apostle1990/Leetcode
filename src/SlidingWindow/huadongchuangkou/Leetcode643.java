package SlidingWindow.huadongchuangkou;

public class Leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for (int i=0;i<k;i++){
            sum = sum + nums[i];
        }
        double res = sum/k;
        for (int i=k;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            res = Math.max(res,sum);
        }
        return res/k;
    }

    public static void main(String[] args) {
        Leetcode643 leetcode643 = new Leetcode643();
        int[] nums = {0,4,0,3,2};
        int k = 1;
        double avg = leetcode643.findMaxAverage(nums,k);
        System.out.println(avg);
    }
}
