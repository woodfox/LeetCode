package first;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
	//This will throw Time Limited Exceeded Error!!
    public ArrayList<Interval> merge(ArrayList<Interval> l) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Collections.sort(l, new IntervalComparator());
        int i = 0;
        while(i < l.size() - 1){
            Interval u = l.get(i);
            Interval v = l.get(i+1);
            if(u.end < v.start){
                i++;
            }else{
                int end = Math.max(u.end, v.end);
                u.end = end;
                l.remove(i+1);
            }
        }
        return l;
    }
    
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            if(a.start <= b.start){
                return -1;
            }else {
                return 1;
            }
        }
    }
}