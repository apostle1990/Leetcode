package BinarySearchTree;

import java.util.HashMap;

//105. 从前序与中序遍历序列构造二叉树
public class Leetcode105 {

    HashMap<Integer, Integer> hashMap;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int prelen = preorder.length;
        int inlen = inorder.length;
        if (prelen!=inlen) return null;
        this.preorder = preorder;
        this.hashMap = new HashMap<>();
        for (int i=0; i<inlen; i++){
            hashMap.put(inorder[i], i);
        }
        return buildTree(0,prelen-1,0,inlen-1);
    }
    private TreeNode buildTree(int prestart, int preend, int instart, int inend){
        if (prestart > preend || instart > inend) return null;

        int p = preorder[prestart];
        TreeNode treeNode = new TreeNode(p);
        int index = hashMap.get(p);
        treeNode.left = buildTree(prestart+1,index - instart+prestart,instart,index-1);
        treeNode.right = buildTree(index - instart+prestart+1,preend,index+1,inend);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Leetcode105 leetcode105 = new Leetcode105();
        leetcode105.buildTree(preorder,inorder);
    }
}
