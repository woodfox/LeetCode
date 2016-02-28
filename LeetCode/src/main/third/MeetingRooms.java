package third;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 For example,

 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 */
public class MeetingRooms {
    /**
     * Sort and compare if any overlap with previous interval
     *
     * Time: O(nlgn)
     */
    boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start <= o2.start) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i=1;i<intervals.size();i++) {
            Interval a = intervals.get(i);
            Interval b = intervals.get(i-1);
            if(a.start < b.end) {
                return false;
            }
        }

        return true;
    }

    /**
     * Brute force with time O(n^2)
     */
    boolean canAttendMeetings_slow(List<Interval> intervals) {
        int n = intervals.size();
        for(int i=0;i<n-1;i++) {
            Interval a = intervals.get(i);
            for(int j=i+1;j<n;j++) {
                Interval b = intervals.get(j);
                if(!(a.start >= b.end || a.end <= b.start)) {
                    return false;
                }
            }
        }

        return true;
    }
}
