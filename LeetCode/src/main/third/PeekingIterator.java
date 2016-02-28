package third;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Integer p = null;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(p == null) {
            p = iterator.next();
        }
        return p;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(p != null) {
            Integer tmp = p;
            p = null;
            return tmp;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        return p != null || iterator.hasNext();
    }

    @Override
    public void remove() {

    }
}