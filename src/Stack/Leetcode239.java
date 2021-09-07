package Stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//滑动窗口最大值
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len ==0) return new int[]{};
        List<Integer> re =  new ArrayList<>(k);
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<len; i++){

            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            // 那么将它弹出
            if (i>=k && i -k == deque.getFirst()) deque.pollFirst();

            // 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            // 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            // 将它们弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.addLast(i);

            // 队首一定是滑动窗口的最大值的索引
            if (i >= k-1) re.add(nums[deque.peekFirst()]);
        }
        int size = re.size();
        int[] result = new int[size];
        for (int i=0; i< size; i++) result[i] = re.get(i);
        return result;
    }
}
