package Stack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackin;
    Stack<Integer> stackout;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackin = new Stack<>();
        stackout = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!stackout.empty()){
            change(stackout,stackin);
        }
        stackin.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackout.empty()){
            change(stackin,stackout);
        }
        return stackout.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackout.empty()){
            change(stackin,stackout);
        }
        return stackout.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stackin.empty() && stackout.empty());
    }

    public void change(Stack<Integer> stack1, Stack<Integer> stack2){
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }

}
