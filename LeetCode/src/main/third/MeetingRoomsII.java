package third;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 For example,

 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 */
public class MeetingRoomsII {
    /**
     * Sort the list by start, and then count the max overlaps by comparing start with the min end.
     *
     * Time: O(nlgn)
     */
    int minMeetingRooms(List<Interval> l) {
        Collections.sort(l, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start <= o2.start) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int count = 0;
        int pos = 0;
        int rooms = 0;
        int n = l.size();
        while(pos < n) {
            while(pos < n && (q.isEmpty() || l.get(pos).start < q.peek())) {
                q.add(l.get(pos).end);
                pos++;
                count++;
            }
            rooms = Math.max(rooms, count);

            q.poll();
            count--;
        }
        return rooms;
    }
}
