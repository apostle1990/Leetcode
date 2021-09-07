package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

//中序遍历
public class Leetcode94 {
    List<Integer> inorder;
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder = new LinkedList<>();
        inordert(root);
        return inorder;
    }
    public void inordert(TreeNode root){
        if (root == null) return ;
        inordert(root.left);
        inorder.add(root.val);
        inordert(root.right);
    }
}
