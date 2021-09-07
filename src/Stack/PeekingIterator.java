package Stack;

import java.util.Iterator;

//284
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer pointp;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (pointp==null) pointp=iterator.next();
        return pointp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (pointp!=null) {
            Integer pointn = pointp;
            pointp = null;
            return pointn;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return pointp !=null || iterator.hasNext();
    }
}