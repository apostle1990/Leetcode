package Stack;

import java.util.Deque;
import java.util.LinkedList;

//柱状图中最大的矩形
public class Leetcode84 {
    public int largestRectangleAreaf(int[] heights) {
        //暴力解法未通过
        int len = heights.length;
        int maxarea = 0;
        for (int i=0; i< len; i++){
            int left=i;
            int right=i;
            while (left>0 && heights[left-1] >= heights[i]) left--;
            while (right<len-1 && heights[right + 1] >= heights[i]) right ++;
            int area = heights[i] * (right - left + 1);
            maxarea = Math.max(maxarea,area);
        }
        return maxarea;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxarea = 0;
        int[] newheights = new int[len +2];
        newheights[0] = 0;
        System.arraycopy(heights,0, newheights, 1, len);
        newheights[len +1] =0;
        len +=2;
        heights = newheights;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);

        for (int i=0; i<len; i++){
            while (heights[i] < heights[stack.peekLast()]){
                int height = heights[stack.pollLast()];
                int width = i - stack.peekLast() -1;
                maxarea = Math.max(maxarea,height * width);
            }
            stack.addLast(i);
        }
        return maxarea;
    }

    public static void main(String[] args) {
         int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1, 1};
        Leetcode84 solution = new Leetcode84();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}
