package chapter7;

public class Leetcode21 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode sort = pre;
        while (l1 !=null && l2 !=null){
            if (l1.val <= l2.val){
                sort.next = l1;
                l1 = l1.next;
            }else {
                sort.next = l2;
                l2 = l2.next;
            }
            sort = sort.next;
        }
        if (l1 != null) sort.next = l1;
        if (l2 != null) sort.next = l2;
        return pre.next;
    }
}
