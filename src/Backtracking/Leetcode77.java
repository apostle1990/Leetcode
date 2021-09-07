package Backtracking;

import java.util.*;

//77. 组合
public class Leetcode77 {
    Deque<Integer> path;
    List<List<Integer>> res;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.path = new ArrayDeque<>();
        this.res = new ArrayList<>();
        this.k = k;
        DFS(n, 1);
        return res;
    }

    public void DFS(int n, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.addLast(i);
            DFS(n, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Leetcode77 leetcode77 = new Leetcode77();
        List<List<Integer>> res = leetcode77.combine(n, k);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
