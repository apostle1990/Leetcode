package LinkedList;

public class ReverseList {
    public ListNode reverse(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode prev = reverse(head.next);
        head.next.next = head;
        head.next=null;
        return prev;
    }

    public ListNode reverse1(ListNode head){
        ListNode prev =null;
        ListNode node = head;
        while (node!=null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
