package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.

 For example, Given 2d vector = [ [1,2], [3], [4,5,6] ]

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: `[1, 2, 3, 4, 5, 6].
 */
public class Flatten2DVector {
    private List<List<Integer>> l = new ArrayList();
    private int p = 0;
    private int q = 0;

    public Flatten2DVector(List<List<Integer>> l) {
        this.l = l;
    }

    public boolean hasNext() {
        while(p < l.size()) {
            List<Integer> sub = l.get(p);
            if(q < sub.size()) {
                break;
            } else {
                q = 0;
                p++;
            }
        }

        return p < l.size();
    }

    public int next() {
        int x = l.get(p).get(q);
        q++;

        return x;
    }
}
