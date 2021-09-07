package BinarySearchTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//199. 二叉树的右视图
public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        rightviewDFS(root,0,list);
        return list;
    }
    public void rightviewDFS(TreeNode root,int depth,List<Integer> list){
        if (root!=null){
            if (list.size() == depth){
                list.add(root.val);
            }
            rightviewDFS(root.right, depth+1, list);
            rightviewDFS(root.left, depth+1, list);
        }
    }
    public void rightviewBFS(TreeNode root,List<Integer> list){
        if (root ==null) return;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i=0; i<size; i++){
                TreeNode node = deque.poll();
                if (node.left!=null) deque.add(node.left);
                if (node.right!=null) deque.add(node.right);
                if (i==size-1){
                    list.add(node.val);
                }
            }
        }
    }
}
