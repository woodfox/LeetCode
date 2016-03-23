package other;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode的Zigzag Iterator
 比如我们有一个 Iterator>, 这个里边是iterator
 i1 1, 2, 3
 i2 4
 i3 5, 6
 然后结果返回 1,4,5,2,6,3
 Follow up是，如果这些iterator都有hasPrevious(), previous()方法，意思就是后退一步，你的class也应该有这两个方法，来后退一步
 比如我们现在结果返回了 1,4
 这时候原来的iterator变成
 i1 2, 3
 i2
 i3 5, 6
 如果调用previous()，变成
 i1 2, 3
 i2 4
 i3 5, 6
 */
public class ZigzagIteratorWithPrevious {
    /**
     * Need to use LinkedList to save move history, so that it can rollback to previous move.
     */
    List<CustomIterator<Integer>> l;
    int row = 0;

    LinkedList<Integer> moves = new LinkedList();

    public ZigzagIteratorWithPrevious(List<CustomIterator<Integer>> l) {
        this.l = l;
    }

    public boolean hasNext(){
        int n = l.size();
        int available = n;
        while(available > 0) {
            row = row%n;

            if(l.get(row).hasNext()) {
                return true;
            } else{
                available--;
                row++;
            }
        }
        return false;
    }

    public int next() {
        if(hasNext()) {
            // Add move into history
            moves.add(row);

            return l.get(row++).next();
        }
        return -1;
    }

    public boolean hasPrevious(){
        return !moves.isEmpty();
    }

    public void previous() {
        if(hasPrevious()) {
            int prevRow = moves.removeLast();
            l.get(prevRow).previous();
            row = prevRow;
        }
    }

    public static class CustomIterator<T> {
        List<T> list;
        int pos = 0;

        public CustomIterator(List<T> list) {
            this.list = list;
        }

        public boolean hasNext() {
            return pos < list.size();
        }

        public T next() {
            return list.get(pos++);
        }

        public boolean hasPrevious(){
            return pos > 0;
        }
        public void previous() {
            if(hasPrevious()) pos--;
        }
    }
}
