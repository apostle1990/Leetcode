package PriorityQueue;

import java.util.PriorityQueue;

//1296. 划分数组为连续数字的集合
public class Leetcode1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k !=0) return false;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) priorityQueue.add(num);
        while (!priorityQueue.isEmpty()){
            Integer top = priorityQueue.poll();
            for (int i=1; i<k; i++){
                if (!priorityQueue.remove(top+i)){
                    return false;
                }
            }
        }
        return true;
    }
}
