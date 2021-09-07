package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. 子集 II
public class Leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        DFS(nums, 0, path, res, false);
        return res;

    }

    public void DFS(int[] nums, int depth, List<Integer> path, List<List<Integer>> res, boolean isused) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        DFS(nums, depth + 1, path, res, false);
        if (depth > 0 && nums[depth] == nums[depth - 1] && !isused) return;
        path.add(nums[depth]);
        DFS(nums, depth + 1, path, res, true);
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Leetcode90 leetcode90 = new Leetcode90();
        List<List<Integer>> res = leetcode90.subsetsWithDup(nums);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
