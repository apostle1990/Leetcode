package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyStack() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i=0; i<deque.size() -1; i++){
            deque.addLast(deque.removeFirst());
        }
        return deque.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        for (int i=0; i<deque.size() -1; i++){
            deque.addLast(deque.removeFirst());
        }
        int res = deque.removeFirst();
        deque.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
