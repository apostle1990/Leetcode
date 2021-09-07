package LinkedList;

public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head, ListNode tail){
        if(head == null) return head;
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next.next;
            if (fast!= tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode l1 = sortList(head,mid);
        ListNode l2 = sortList(mid,tail);
        return mergeTwoLists(l1,l2);
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
