package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {

    private Map<Integer, Rlistnode> map;

    private int capacity;

    /**
     * 虚拟头结点没有前驱
     */
    private Rlistnode dummyHead;
    /**
     * 虚拟尾结点没有后继
     */
    private Rlistnode dummyTail;

    public LRUCache1(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        dummyHead = new Rlistnode(-1, -1);
        dummyTail = new Rlistnode(-1, -1);
        // 初始化链表为 head <-> tail

        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    /**
     * 如果存在，把当前结点移动到双向链表的头部
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Rlistnode node = map.get(key);
            int val = node.value;

            // 把当前 node 移动到双向链表的头部
            moveNode2Head(key);
            return val;
        } else {
            return -1;
        }
    }

    /**
     * 如果哈希表的容量满了，就要删除一个链表末尾元素，然后在链表头部插入新元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 1、更新 value
            map.get(key).value = value;
            // 2、把当前 node 移动到双向链表的头部
            moveNode2Head(key);
            return;
        }

        // 放元素的操作是一样的

        if (map.size() == capacity) {
            // 如果满了
            Rlistnode oldTail = removeTail();

            // 设计 key 就是为了在这里删除
            map.remove(oldTail.key);
        }

        // 然后添加元素
        Rlistnode newNode = new Rlistnode(key, value);
        map.put(key, newNode);
        addNode2Head(newNode);
    }

    // 为了突出主干逻辑，下面是 3 个公用的方法

    /**
     * 删除双链表尾部结点
     */
    private Rlistnode removeTail() {
        Rlistnode oldTail = dummyTail.pre;
        Rlistnode newTail = oldTail.pre;

        // 两侧结点建立连接
        newTail.next = dummyTail;
        dummyTail.pre = newTail;

        // 释放引用
        oldTail.pre = null;
        oldTail.next = null;

        return oldTail;
    }

    /**
     * 把当前 key 指向的结点移到双向链表的头部
     *
     * @param key
     */
    private void moveNode2Head(int key) {
        // 1、先把 node 拿出来
        Rlistnode node = map.get(key);

        // 2、原来 node 的前驱和后继接上
        node.pre.next = node.next;
        node.next.pre = node.pre;

        // 3、再把 node 放在末尾
        addNode2Head(node);
    }

    /**
     * 在双链表的头部新增一个结点
     *
     * @param newNode
     */
    private void addNode2Head(Rlistnode newNode) {
        // 1、当前头结点
        Rlistnode oldHead = dummyHead.next;

        // 2、末尾结点的后继指向新结点
        oldHead.pre = newNode;

        // 3、设置新结点的前驱和后继
        newNode.pre = dummyHead;
        newNode.next = oldHead;

        // 4、更改虚拟头结点的后继结点
        dummyHead.next = newNode;
    }


    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.map.keySet());

        int res1 = cache.get(1);
        System.out.println(res1);

        cache.put(3, 3);

        int res2 = cache.get(2);
        System.out.println(res2);

        int res3 = cache.get(3);
        System.out.println(res3);

        cache.put(4, 4);
        System.out.println(cache.map.keySet());

        int res4 = cache.get(1);
        System.out.println(res4);

        int res5 = cache.get(3);
        System.out.println(res5);

        int res6 = cache.get(4);
        System.out.println(res6);
    }
}