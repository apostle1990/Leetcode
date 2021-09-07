package BinarySearchTree;

//109. 有序链表转换二叉搜索树
public class Leetcode109 {

    ListNode gobalhead;

    public TreeNode sortedListToBST(ListNode head) {
        gobalhead = head;
        int len = getLength(head);
        return buildtree(0, len-1);
    }
    public int getLength(ListNode head){
        int len =0;
        while (head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    public TreeNode buildtree(int left, int right){
        if (left > right) return null;

        int mid = (right - left +1)/2 +left;

        TreeNode root = new TreeNode();
        root.left = buildtree(left, mid-1);
        root.val = gobalhead.val;
        gobalhead = gobalhead.next;
        root.right = buildtree(mid+1, right);

        return root;
    }
}
