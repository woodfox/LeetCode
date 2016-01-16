package second;

import java.util.ArrayList;

public class InsertInterval {
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

    public ArrayList<Interval> insert(ArrayList<Interval> l, Interval v) {
        ArrayList<Interval> r = new ArrayList<Interval>();
        int p = 0;
        int n = l.size();
        while(p<n && l.get(p).end < v.start){
            r.add(l.get(p));
            p++;
        }
        while(p < n){
            Interval u = l.get(p);
            if(u.start > v.end){
                break;
            }
            v.start = Math.min(v.start, u.start);
            v.end = Math.max(v.end, u.end);
            p++;
        }
        
        r.add(v);
        while(p < n){
            r.add(l.get(p++));
        }
        
        return r;
    }
}
