package LinkedList;

public class MyLinkedList {

    int size;
    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size =0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size ) return -1;
        ListNode node = head;
        for (int i=0; i<index+1; ++i){ node = node.next;}
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index >size) return;
        if(index <0) index=0;
        ++size;
        ListNode pre =head;
        for (int i=0; i < index; ++i) pre= pre.next;
        ListNode toadd = new ListNode(val);
        toadd.next = pre.next;
        pre.next = toadd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0 || index>=size) return;
        size--;
        ListNode node = head;
        for (int i =0; i< index; ++i) node = node.next;
            node.next = node.next.next;
    }
}
