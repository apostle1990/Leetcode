package SlidingWindow.shuangzhizhen;

public class Leetcode167 {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length-1;
            while (left < right){
                if (numbers[left]+numbers[right]>target) right--;
                else if (numbers[left]+numbers[right]<target) left++;
                else if (numbers[left]+numbers[right]==target) break;
            }
            return new int[]{left + 1 ,right + 1};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] twonum = solution.twoSum(numbers , target);
        for (int i:twonum){
            System.out.println(i);
        }
    }
}
