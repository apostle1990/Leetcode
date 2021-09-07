package LinkedList;

public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode first =new ListNode(0);
        first.next = head;
        ListNode lastsorted = head,curr = head.next;
        while (curr!=null){
            if (lastsorted.val <= curr.val) lastsorted = lastsorted.next;
            else {
                ListNode prev = first;
                while (prev.next.val <= curr.val) prev = prev.next;
                lastsorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastsorted.next;
        }
        return first.next;
    }
}
