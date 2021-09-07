package LinkedList;

//跳表
public class Skiplist {
    public class Node{
        Integer value;
        Node[] next;
        public Node(Integer value, int size){
            this.value = value;
            this.next = new Node[size];
        }
    }

    private static int MAX_LEVEL = 32;
    private static double p_factor = 0.25f;

    private int levelcount = 1;

    Node head = new Node(null, MAX_LEVEL);

    public Skiplist() {
    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = levelcount -1; i>=0; i--){
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i]!=null && searchNode.next[i].value == target){
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = randomlevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        for (int i = levelcount-1; i>=0; i--) {
            //找到本层最近离num最近的list
            updateNode = findClosest(updateNode,i,num);
            if (i<level){
                if (updateNode.next[i]==null){
                    updateNode.next[i] = newNode;
                }else{
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > levelcount){ //如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
            for (int i = levelcount; i < level; i++) {
                head.next[i] = newNode;
            }
            levelcount = level;
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = levelcount-1; i >=0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i]!=null && searchNode.next[i].value == num){
                //找到该层中该节点
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }

    private Node findClosest(Node node, int levelindex, int value){
        while ((node.next[levelindex])!=null && value >node.next[levelindex].value){
            node = node.next[levelindex];
        }
        return node;
    }

    private static int randomlevel(){
        int level =1;
        while (Math.random() < p_factor && level < MAX_LEVEL){
            level++;
        }
        return level;
    }
}
