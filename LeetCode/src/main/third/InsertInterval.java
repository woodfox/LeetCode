package third;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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
