package other;

import java.util.LinkedList;
import java.util.List;

public class ClosetKValues {
    public List<Integer> findKCloset(int[] a, double t, int k) {
        LinkedList<Integer> q = new LinkedList();
        for(int x : a) {
            if(q.size() < k) {
                q.addLast(x);
            } else {
                int first = q.getFirst();
                if(Math.abs(x-t) < Math.abs(first-t)){
                    q.removeFirst();
                    q.addLast(x);
                } else {
                    // Do not need to try remaining values; they are larger than existing k values.
                    return q;
                }
            }
        }

        return q;
    }
 }
