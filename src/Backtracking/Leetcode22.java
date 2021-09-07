package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    int n;
    List<String> combations = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        StringBuffer str = new StringBuffer();
        DFS(str, 0, 0);
        return combations;
    }

    public void DFS(StringBuffer str, int open, int close) {
        if (str.length() == 2 * n) {
            combations.add(str.toString());
            return;
        }
        if (open < n) {
            str.append('(');
            DFS(str, open + 1, close);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(')');
            DFS(str, open, close + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        List<String> combations = leetcode22.generateParenthesis(3);
        for (String str : combations) {
            System.out.println(str);
        }
    }

}
