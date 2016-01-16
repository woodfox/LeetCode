package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> l) {
        ArrayList<Interval> r = new ArrayList<Interval>();
        Collections.sort(l, new IntervalComparator());
        int p = 0;
        Interval v = null;
        while(p < l.size()){
            Interval u = l.get(p);
            if(v == null){
                v = u;
            }else if(u.start > v.end){
                r.add(v);
                v = u;
            }else{
                v.end = Math.max(v.end, u.end);
            }
            p++;
        }
        if(v != null){
            r.add(v);
        }
        return r;
    }
    
    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            if(a.start < b.start){
                return -1;
            }else if(a.start == b.start){
                return 0;
            }else{
                return 1;
            }
        }
    }

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
