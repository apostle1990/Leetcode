package Stack;

import java.util.Stack;
//Leetcode155
public class MinStack {
    Stack<Integer> data;
    Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (!helper.empty() && helper.peek()<val){
            helper.push(helper.peek());
        }else {
            helper.push(val);
        }
    }

    public void pop() {
        data.pop();
        helper.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
