package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

//二叉搜索树第K大的元素
public class Leetcode230 {
    List<Integer> inorder;
    public int kthSmallest(TreeNode root, int k) {
        inorder = new ArrayList<>();
        inordert(root);
        return inorder.get(k-1);
    }

    public void inordert(TreeNode root){
        if (root == null) return ;
        inordert(root.left);
        inorder.add(root.val);
        inordert(root.right);
    }
}
