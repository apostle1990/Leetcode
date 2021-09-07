package Backtracking;

import java.util.*;

public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        boolean[] used = new boolean[len];

        Deque<Integer> path = new ArrayDeque<>(len);
        Arrays.sort(nums);
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> path,
                    boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        Leetcode47 leetcode47 = new Leetcode47();
        List<List<Integer>> res = leetcode47.permuteUnique(nums);
    }
}
