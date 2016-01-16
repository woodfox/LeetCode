package first;
import java.util.ArrayList;

public class InsertInterval {   
    public ArrayList<Interval> insert(ArrayList<Interval> l, Interval a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> r = new ArrayList<Interval>();
        int i = 0;
        while (i < l.size()) {
            Interval v = l.get(i);
            if (v.end < a.start) {
                r.add(v);
            }
            else if (v.start > a.end) {
                break;
            }
            else {
                a.start = Math.min(a.start, v.start);
                a.end = Math.max(a.end, v.end);
            }
            i++;
        }
        r.add(a);
        while (i < l.size()) {
            r.add(l.get(i));
            i++;
        }
        return r;
    }
    
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
