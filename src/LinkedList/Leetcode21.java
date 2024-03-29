package LinkedList;

public class Leetcode21 {
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
