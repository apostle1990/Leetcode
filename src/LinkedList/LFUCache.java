package LinkedList;

import java.util.*;

public class LFUCache {
    private class ListNode{
        int key;
        int value;
        int freq;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            this.freq  = 1;
        }
    }

    private class DoubleLinkList{
        private ListNode dummyhead;
        private ListNode dummytail;

        private int length;

        public DoubleLinkList(){
            this.dummyhead = new ListNode(-1,-1);
            this.dummytail = new ListNode(-1,-1);
            dummyhead.next = dummytail;
            dummytail.pre = dummyhead;
        }

        private ListNode removeTail(){
            return removenode(dummytail.pre);
        }

        private void add2head(ListNode node){
            ListNode curhead = dummyhead.next;

            node.next = curhead;
            curhead.pre = node;

            dummyhead.next = node;
            node.pre = dummyhead;

            length++;
        }

        private ListNode removenode(ListNode node){
            map.remove(node.key);

            ListNode pre = node.pre;
            ListNode next = node.next;

            pre.next = next;
            next.pre = pre;

            pre = null;
            next = null;

            length--;

            return node;
        }
    }

    private int capacity;
    private int minfreq;
    private HashMap<Integer, ListNode> map;
    private HashMap<Integer, DoubleLinkList> freqmap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minfreq =1;
        map = new HashMap<>();
        freqmap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity==0) return -1;
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            accesslistnode(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity ==0) return;
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;
            accesslistnode(node);
        }else {
            if (map.size() ==capacity){
                DoubleLinkList doubleLinkList = freqmap.get(minfreq);
                ListNode tail = doubleLinkList.removeTail();
            }
            ListNode node = new ListNode(key,value);
            addlistnode(1,node);
            minfreq =1;
        }
    }

    private void removelistnode(ListNode listNode){
        map.remove(listNode.key);
        int freq = listNode.freq;
        DoubleLinkList doubleLinkList = freqmap.get(freq);
        doubleLinkList.removenode(listNode);

        if (freq == minfreq && doubleLinkList.length==0){
            minfreq++;
        }
    }

    private void addlistnode(int freq, ListNode listNode){
        map.put(listNode.key, listNode);

        listNode.freq = freq;

        DoubleLinkList doubleLinkList = freqmap.get(freq);

        if (doubleLinkList == null){
            doubleLinkList = new DoubleLinkList();
            freqmap.put(freq,doubleLinkList);
        }
        doubleLinkList.add2head(listNode);
    }

    private void accesslistnode(ListNode listnode){
        int freq = listnode.freq;
        removelistnode(listnode);
        addlistnode(freq +1, listnode);
    }
}
