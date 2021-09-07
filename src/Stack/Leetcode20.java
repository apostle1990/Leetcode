package Stack;

import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0; i<s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (!stack.empty()){
                        char sch1 = stack.pop();
                        if (sch1 == '(') break;
                    }
                    return false;
                case '}':
                    if (!stack.empty()){
                        char sch2 = stack.pop();
                        if (sch2 == '{') break;
                    }
                    return false;
                case ']':
                    if (!stack.empty()){
                        char sch3 = stack.pop();
                        if (sch3 == '[') break;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return stack.empty();
    }
}
