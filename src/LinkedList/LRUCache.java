package LinkedList;

import java.util.HashMap;

public class LRUCache {

    private int capacity;
    private int size;
    private ListNode head;

    private HashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Use(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size==0){
            head = new ListNode(key);
            cache.put(key,value);
            size++;
            return;
        }
        if (cache.containsKey(key)){
            cache.put(key,value);
            Use(key);
        }else {
            size++;
            if (size>capacity){
                ListNode q = head;
                for (int i=1; i<capacity; i++) q=q.next;
                int k = q.val;
                cache.remove(k);
            }
            cache.put(key,value);
            head = new ListNode(key,head);
        }
    }

    public void Use(int key){
        ListNode pre = new ListNode(0,head);
        while (pre!=null){
            if (pre.next.val == key){
                ListNode change = pre.next;
                pre.next = pre.next.next;
                change.next = head;
                head=change;
                return;
            }
            pre = pre.next;
        }
    }
}
