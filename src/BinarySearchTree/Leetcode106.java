package BinarySearchTree;

import java.util.HashMap;

//106. 从中序与后序遍历序列构造二叉树
public class Leetcode106 {

    HashMap<Integer, Integer> hashMap;
    int[] postorder;

    public TreeNode buildTree(int[] inoreder, int[] postorder) {
        int postlen = postorder.length;
        int inlen = inoreder.length;
        if (postlen!=inlen) return null;
        this.postorder = postorder;
        this.hashMap = new HashMap<>();
        for (int i=0; i<inlen; i++){
            hashMap.put(inoreder[i], i);
        }
        return buildTree(0,inlen-1,0,postlen-1);
    }
    private TreeNode buildTree(int instart, int inend,int poststart, int postend){
        if (poststart > postend || instart > inend) return null;

        int p = postorder[postend];
        TreeNode treeNode = new TreeNode(p);
        int index = hashMap.get(p);
        treeNode.left = buildTree(instart,index-1,poststart,postend+index-inend);
        treeNode.right = buildTree(index+1,inend,postend+index-inend,postend-1);
        return treeNode;
    }
}
