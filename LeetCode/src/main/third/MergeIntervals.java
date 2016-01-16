package third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        List<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();
        int pos = 0;
        while(pos < n){
            Interval base = intervals.get(pos);
            for(;pos<n;pos++){
                Interval next = intervals.get(pos);
                if(next.start <= base.end) {
                    base.end = Math.max(base.end, next.end);
                }else{
                    break;
                }
            }
            result.add(base);
        }

        return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start < o2.start){
                return -1;
            }else if(o1.start == o2.start) {
                return 0;
            }else{
                return 1;
            }
        }
    }
}
