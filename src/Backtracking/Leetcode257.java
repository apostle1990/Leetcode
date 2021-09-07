package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        DFS(root, "");
        return result;
    }

    public void DFS(TreeNode root, String str) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(str);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                result.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                DFS(root.left, pathSB.toString());
                DFS(root.right, pathSB.toString());
            }
        }
    }
}
