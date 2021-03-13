package chapter7;

public class Leetcode24 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null || head.next.next ==null) return head;
//        ListNode p = head.next;
//        head.next = swapPairs(p.next);
//        p.next = head;
        ListNode re = head.next.next;
        ListNode p = head.next;
        p.next = head;
        head.next = swapPairs(re);
        return p;
    }

}
