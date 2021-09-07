package LinkedList;

public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        //digui
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val){
            while (head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
