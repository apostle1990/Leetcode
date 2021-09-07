package Backtracking;

import java.util.ArrayList;
import java.util.List;

//78. 子集
public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        DFS(nums, 0, path, res);
        return res;

    }

    public void DFS(int[] nums, int depth, List<Integer> path, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[depth]);
        DFS(nums, depth + 1, path, res);
        path.remove(path.size() - 1);
        DFS(nums, depth + 1, path, res);
    }
}
