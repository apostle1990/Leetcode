package LinkedList;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          int up=0;
          ListNode head = new ListNode(0);
          ListNode next = head;
          while (l1!=null || l2!=null){
              int n1 = l1 == null ? 0 : l1.val;
              int n2 = l2 == null ? 0 : l2.val;
              int temp = (n1 + n2 + up) % 10;
              up = (n1 + n2 + up) >9 ? 1 : 0;//da
              next.next = new ListNode(temp);
              next = next.next;
              if (l1!=null)l1 = l1.next;
              if (l2!=null)l2 = l2.next;
              if (up == 1){
                  next.next = new ListNode(up);
              }
          }
          return head.next;
    }
}
