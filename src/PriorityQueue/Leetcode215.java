package PriorityQueue;

import java.util.PriorityQueue;

//数组中第K个最大元素
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums){
            priorityQueue.add(num);
        }
        int n = nums.length - k;
        while (n >0){
            priorityQueue.poll();
            n--;
        }
        return priorityQueue.peek();
    }
}
