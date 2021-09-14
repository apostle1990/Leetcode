package SlidingWindow.huadongchuangkou;

public class Leetcode1493 {
    public int longestSubarray(int[] nums) {
        int len = nums.length, res =0, cnt =0;
        for (int i=0,j=0; i<len; i++){
            if (nums[i] ==0) cnt++;
            while (cnt>1){
                if (nums[j++] ==0) cnt--;
            }
            res = Math.max(res,i-j);
        }
        return res;
    }
}
