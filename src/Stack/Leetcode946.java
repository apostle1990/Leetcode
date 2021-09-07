package Stack;

import java.util.Stack;

//验证栈序列
public class Leetcode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = popped.length;
        int pu = 0, po = 0;
        while (pu<len){
            if (pushed[pu] == popped[po]){
                po++;
                if (!stack.empty()){
                    pushed[pu]=stack.pop();
                }else {
                    pu++;
                }
            }else {
                stack.push(pushed[pu]);
                pu++;
            }
        }
        while (po <len){
            if (popped[po] == stack.pop()){
                po++;
            }else return false;
        }
        return true;
    }
}
