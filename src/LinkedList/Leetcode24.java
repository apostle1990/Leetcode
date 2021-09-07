package LinkedList;

public class Leetcode24 {
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
