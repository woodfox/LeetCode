package third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIteratorWithKList_queue {
    private List<LinkedList<Integer>> queues = new ArrayList();
    private int k = 0;

    public ZigzagIteratorWithKList_queue(List<List<Integer>> l) {
        for(List<Integer> sub : l) {
            LinkedList<Integer> q = new LinkedList(sub);
            queues.add(q);
        }
    }

    public boolean hasNext() {
        while(!queues.isEmpty()) {
            if(k>=queues.size()) k=0;
            LinkedList<Integer> q = queues.get(k);
            if(q.isEmpty()) {
                queues.remove(k);
            } else {
                return true;
            }
        }

        return false;
    }

    public int next() {
        if(!hasNext()) return -1;
        return queues.get(k++).removeFirst();
    }
}