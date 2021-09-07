package PriorityQueue;

import java.util.PriorityQueue;

//295. 数据流的中位数
public class MedianFinder {

    private int len;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.len = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        len++;
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if ((len & 1) !=0) maxheap.add(minheap.poll());
    }

    public double findMedian() {
        if ((len & 1) ==0){
            return (double) (maxheap.peek() + minheap.peek()) /2;
        }else {
            return (double)  maxheap.peek();
        }
    }
}
