package Backtracking;

import java.util.*;

public class Leetcode40 {
    Deque<Integer> path;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.path = new ArrayDeque<>();
        this.res = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates, target, 0);
        return res;
    }

    public void DFS(int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Leetcode40 leetcode40 = new Leetcode40();
        List<List<Integer>> res = leetcode40.combinationSum2(candidates, target);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
