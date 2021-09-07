package Stack;

import java.util.Deque;
import java.util.LinkedList;
//日期

public class Leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] re = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<len; i++){
            int t = T[i];
            while (!stack.isEmpty() && t > T[stack.peekLast()]){
                int prev = stack.pollLast();
                re[prev] = i - prev;
            }
            stack.addLast(i);
        }
        return re;
    }
}
