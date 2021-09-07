package Backtracking;

import java.util.*;

//39. 组合总和
public class Leetcode39 {
    Deque<Integer> path;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.path = new ArrayDeque<>();
        this.res = new ArrayList<>();
        DFS(candidates, target, 0);
        return res;
    }

    public void DFS(int[] candidates, int target, int begin) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            DFS(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Leetcode39 leetcode39 = new Leetcode39();
        List<List<Integer>> res = leetcode39.combinationSum(candidates, target);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
