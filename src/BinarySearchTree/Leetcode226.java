package BinarySearchTree;

//226. 翻转二叉树
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }
}
