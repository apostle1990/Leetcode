package PriorityQueue;

import java.util.PriorityQueue;

//703数据流中的第 K 大元素
public class KthLargest {
    private PriorityQueue<Integer> minheap;
    int k;

    public KthLargest(int k, int[] nums) {
        minheap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minheap.add(val);
        if (minheap.size()>k) minheap.poll();
        return minheap.peek();
    }

    public static void main(String[] args) {
        int[] nums ={};
        int k =1;
        KthLargest kthLargest = new KthLargest(k,nums);
        int re = kthLargest.add(-3);
        System.out.println(re);
    }
}
