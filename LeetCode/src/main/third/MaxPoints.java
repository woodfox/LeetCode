package third;

import util.Point;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    /**
     * Check every line between two points and count the numbers by angle and pos.
     * Time: O(n^2)
     *
     * Be Careful:
     * 1. Duplicate points!
     * 2. Line with same x which doesn't need to compare pos!
     * 3. Reset map when changing starting point to avoid duplicate calculation!
     */
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        int max = 0;
        int n = points.length;
        for(int i=0;i<n;i++) {
            // Calculate max points in same line starting form points[i]
            Map<Line, Integer> map = new HashMap<Line, Integer>();
            // Base is the number of starting points, while map saves number of other points
            int base = 1;
            int othersMax = 0;
            for(int j=i+1;j<n;j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    base++;
                    continue;
                }

                Line l = new Line(points[i], points[j]);
                Integer count = map.get(l);
                if(count == null) {
                    count = 0;
                }
                count++;
                map.put(l, count);
                othersMax = Math.max(othersMax, count);
            }
            max = Math.max(max, othersMax+base);
        }

        return max;
    }


    class Line {
        float angle;
        float pos;

        public Line(Point a, Point b) {
            if(a.x == b.x) {
                angle = Float.MAX_VALUE;
                // No pos here!! Otherwise hasCode will be different for same line
                pos = 0;
            } else {
                angle = ((float)(b.y - a.y))/(b.x - a.x);
                pos = a.y - angle * a.x;
            }
        }

        @Override
        public int hashCode(){
            return (int)(17 + angle + pos);
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }

            if (o == this){
                return true;
            }

            if(! (o instanceof Line)) {
                return false;
            } else {
                Line l = (Line)o;
                double minDiff = 0.0000000001;

                if(l.angle == Float.MAX_VALUE && this.angle == Float.MAX_VALUE) {
                    // Doesn't need to check pos here
                    return true;
                } else if(l.angle == Float.MAX_VALUE || this.angle == Float.MAX_VALUE) {
                    return false;
                } else {
                    return Math.abs((double) l.angle - this.angle) < minDiff
                            && Math.abs(l.pos - this.pos) < minDiff;
                }
            }
        }
    }
}
