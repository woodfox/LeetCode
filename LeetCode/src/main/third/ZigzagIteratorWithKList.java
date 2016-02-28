package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Extend to k lists:
 *
 * Time: O(n*klgk), n is the average length of list
 */
public class ZigzagIteratorWithKList {
    private List<List<Integer>> l = new ArrayList();
    int row = 0;
    int col = 0;

    public ZigzagIteratorWithKList(List<List<Integer>> l) {
        // to avoid immutable list in scala test
        this.l.addAll(l);
    }

    public boolean hasNext() {
        while(l.size() > 0) {
            // Remove entry if col is exceeding its length
            while(row < l.size() && col >= l.get(row).size()) {
                l.remove(row);
            }

            if(row < l.size()) {
                break;
            } else {
                row = 0;
                col++;
            }
        }

        return row < l.size();
    }

    public int next() {
        if(!hasNext()) return -1;

        int x = l.get(row).get(col);
        row++;
        return x;
    }
}