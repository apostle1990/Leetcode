package SlidingWindow.shuangzhizhen;

public class Leetcode11 {
    static class Solution {
        public static int maxArea1(int[] height) {
            int MaxArea = 0;
            for (int right=0;right<height.length-1;right++){
                for (int left=right+1;left<height.length;left++){
                    int min = Math.min(height[right],height[left]);
                    int area = min * (left - right);
                    MaxArea = Math.max(area,MaxArea);
                }
            }
            return MaxArea;
        }

        public static int maxArea2(int[] height) {
            int MaxArea = 0;
            int right = 0;
            int left = height.length-1;
            while (right < left){
                int min = Math.min(height[left],height[right]);
                int area = min * (left - right);
                MaxArea = Math.max(MaxArea,area);
                if (height[left]>height[right]){
                    right++;
                }else {
                    left--;
                }
            }
            return MaxArea;
        }
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = Solution.maxArea2(height);
        System.out.println(i);
    }
}
