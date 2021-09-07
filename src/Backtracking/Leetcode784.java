package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode784 {
    List<String> combations = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        DFS(0, S, new StringBuffer());
        return combations;
    }

    public void DFS(int index, String S, StringBuffer str) {
        if (index == S.length()) {
            combations.add(str.toString());
            return;
        } else {
            char ch = S.charAt(index);
            str.append(ch);
            DFS(index + 1, S, str);
            str.deleteCharAt(str.length() - 1);
            if (Character.isLetter(ch)) {//判断是否为数字
                ch ^= 1 << 5;//位运算更改ACSLL码
                str.append(ch);
                DFS(index + 1, S, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode784 leetcode784 = new Leetcode784();
        String S = "c";
        List<String> combations = leetcode784.letterCasePermutation(S);
        for (String s : combations) {
            System.out.println(s);
        }
    }
}
