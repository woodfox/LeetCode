package third;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval x) {
        List<Interval> result = new ArrayList<Interval>();

        boolean added = false;
        for(Interval a : intervals) {
            if(a.end < x.start) {
                // Intervals before x
                result.add(a);
            }else if(a.start > x.end) {
                // Intervals after x
                // it should add x if not yet
                if(!added) {
                    result.add(x);
                    added = true;
                }
                result.add(a);
            } else {
                x.start = Math.min(x.start, a.start);
                x.end = Math.max(x.end, a.end);
            }
        }

        if(!added) result.add(x);

        return result;
    }

    public List<Interval> insert_complex(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();
        int pos = 0;
        for(;pos<n;pos++){
            Interval interval = intervals.get(pos);
            if(interval.end >= newInterval.start) break;

            result.add(interval);
        }

        for(;pos<n;pos++){
            Interval interval = intervals.get(pos);
            if(interval.start > newInterval.end) break;

            newInterval.start = Math.min(newInterval.start, interval.start);
            newInterval.end = Math.max(newInterval.end, interval.end);
        }
        result.add(newInterval);

        for(;pos<n;pos++){
            result.add(intervals.get(pos));
        }
        return result;
    }
}
