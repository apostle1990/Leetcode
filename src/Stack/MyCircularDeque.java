package Stack;

//641
public class MyCircularDeque {

    int front, rear, len,count;
    int[] deque;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.front = 0;
        this.rear = 0;
        this.len = k +1;
        deque = new int[this.len];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front -1 + len) % len;
        deque[front] = value;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque[rear] = value;
        rear = (rear + 1) % len;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % len;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear -1 + len) % len;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[(rear -1 + len) % len];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front ==rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear +1)% len == front;
    }
}
