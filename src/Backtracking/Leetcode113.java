package Backtracking;

import java.util.*;

//113. 路径总和 II
public class Leetcode113 {
    Deque<Integer> path;
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new ArrayDeque<>();
        result = new ArrayList<>();
        DFS(root, targetSum);
        return result;
    }

    public void DFS(TreeNode root, int targetSum) {
        if (root == null) return;
        path.addLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        DFS(root.left, targetSum);
        DFS(root.right, targetSum);
        path.removeLast();
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
