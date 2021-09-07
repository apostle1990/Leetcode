package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

//23
public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists ==null || lists.length ==0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!priorityQueue.isEmpty()){
            tail.next = priorityQueue.poll();
            tail = tail.next;
            if (tail.next !=null){
                priorityQueue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
