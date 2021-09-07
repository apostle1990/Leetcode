package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] chs = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chs[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(chs, 0, n, res);
        return res;
    }

    public void dfs(char[][] chs, int row, int n, List<List<String>> res) {
        if (row == n) {
            res.add(ChsToList(chs));
            return;
        }
        for (int i = 0; i < chs[0].length; i++) {
            if (isvaild(chs, row, i)) {
                chs[row][i] = 'Q';
                dfs(chs, row + 1, n, res);
                chs[row][i] = '.';
            }
        }
    }

    public List<String> ChsToList(char[][] chs) {
        List<String> list = new ArrayList<>();
        for (char[] ch : chs) {
            list.add(new String(ch));
        }
        return list;
    }

    public boolean isvaild(char[][] chs, int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                if (chs[i][j] == 'Q' && (j == y || Math.abs(x - i) == Math.abs(y - j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        List<List<String>> res = leetcode51.solveNQueens(4);
        for (List<String> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
