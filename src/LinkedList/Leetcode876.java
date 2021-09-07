package LinkedList;
//876. 链表的中间结点
public class Leetcode876 {
    //快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode ans = head,quick = head;
        while (ans!=null && quick!=null){
            ans = ans.next;
            quick = quick.next.next;
        }
        return ans;
    }

}
