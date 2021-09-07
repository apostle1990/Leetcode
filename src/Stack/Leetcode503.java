package Stack;

import java.util.*;

//下一个更大数组2
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] re = new int[len];
        Arrays.fill(re, -1);
        for (int i=0; i<len * 2 -1; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i % len]){
                re[stack.removeLast()] = nums[i % len];
            }
            stack.addLast(i % len);
        }
        return re;
    }

    public static void main(String[] args) {
        Leetcode503 leetcode503 = new Leetcode503();
        int[] nums = {5,4,3,2,1};
        int[] re = leetcode503.nextGreaterElements(nums);
        System.out.println(Arrays.toString(re));
    }
}
