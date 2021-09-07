package Stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//341
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> deque = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i=nestedList.size()-1; i >=0; i--){
            deque.offerFirst(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return deque.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (deque.isEmpty()){
            return false;
        }else {
            if (!deque.peekFirst().isInteger()){
                List<NestedInteger> list = deque.pollFirst().getList();
                for (int i=list.size()-1; i >=0; i--){
                    deque.offerFirst(list.get(i));
                }
                return hasNext();
            }else {
                return true;
            }
        }
    }
}
