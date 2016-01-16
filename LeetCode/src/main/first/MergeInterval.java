package first;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> l) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> r = new ArrayList<Interval>();
        Collections.sort(l, new IntervalComparator());
        if (l.size() == 0) {
            return r;
        }
        Interval tmp = l.get(0);
        int i = 1;
        while (i < l.size()) {
            Interval u = l.get(i);
            if (tmp.end < u.start) {
                r.add(tmp);
                tmp = u;
            }
            else {
                tmp.end = Math.max(tmp.end, u.end);
            }
            i++;
        }
        r.add(tmp);
        return r;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start <= b.start) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    
    
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
