import chapter7.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        linkedList.get(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(5);
        linkedList.deleteAtIndex(3);
        linkedList.addAtHead(7);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(4);
    }
}
