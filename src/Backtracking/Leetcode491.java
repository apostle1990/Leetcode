package Backtracking;

import java.util.*;

public class Leetcode491 {
    Deque<Integer> path = new ArrayDeque<>();
    ;
    List<List<Integer>> res = new ArrayList<>();
    ;

    public List<List<Integer>> findSubsequences(int[] nums) {
        DFS(0, Integer.MIN_VALUE, nums);
        return res;
    }

    public void DFS(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (nums[cur] >= last) {
            path.add(nums[cur]);
            DFS(cur + 1, nums[cur], nums);
            path.removeLast();
        }
        if (nums[cur] != last) {
            DFS(cur + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        int[] num = {4, 6, 7, 7};
        Leetcode491 leetcode491 = new Leetcode491();
        List<List<Integer>> res = leetcode491.findSubsequences(num);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
