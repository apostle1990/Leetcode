package Stack;

//622
public class MyCircularQueue {
    int count,len,front;
    int[] deque;
    public MyCircularQueue(int k) {
        this.count = 0;
        this.len = k;
        this.front =0;
        deque = new int[k];
    }

    public boolean enQueue(int value) {
        if (count == len) return false;
        deque[(front + count) % this.len] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) return false;
        front = (front + 1) % len;
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) return -1;
        return deque[front];
    }

    public int Rear() {
        if (count == 0) return -1;
        return deque[(front + count -1) % len];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == len;
    }
}
