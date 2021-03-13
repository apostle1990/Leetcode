package chapter7;
//876. 链表的中间结点
public class Leetcode876 {
    //快慢指针
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode middleNode(ListNode head) {
        ListNode ans = head,quick = head;
        while (ans!=null && quick!=null){
            ans = ans.next;
            quick = quick.next.next;
        }
        return ans;
    }

}
