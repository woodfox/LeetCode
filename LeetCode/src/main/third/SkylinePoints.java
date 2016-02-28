package third;

import java.util.*;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
 The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

 For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

 Notes:

 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class SkylinePoints {
    /**
     * Sort left and right edges by X, and maintain current max heights (for left edge, delete height, for right dege, add height);
     * And check if height changes; if height changes, add (x, currentHeight) to result
     *
     * Time: O(n)
     */
    public List<int[]> getSkyline(int[][] b) {
        List<int[]> result = new ArrayList();
        if (b.length == 0) {
            return result;
        }

        // PointQueue is sorted by (x, y)
        PriorityQueue<Point> pointQueue = new PriorityQueue<Point>();
        for(int i=0;i<b.length;i++) {
            // Set height as negative for left edge, and positive for right edge
            pointQueue.add(new Point(b[i][0], -1 * b[i][2]));
            pointQueue.add(new Point(b[i][1], b[i][2]));
        }

        int prevHeight = 0;
        // heightQueue is sorted by height, should get Last which is max
        PriorityQueue<Integer> heightQueue = new PriorityQueue<Integer>();
        heightQueue.add(0);
        while(!pointQueue.isEmpty()) {
            Point p = pointQueue.poll();
            if(p.y < 0) {
                // for left edge, save negative value so that bigger height is sorted at first
                heightQueue.add(p.y);
            } else {
                // Remove same heights from heightQueue
                heightQueue.remove(p.y * -1);
            }

            // Try to insert handle edges with same X at same time!
            if(!pointQueue.isEmpty() && pointQueue.peek().x == p.x){
                continue;
            }

            int current = 0;
            if(!heightQueue.isEmpty()) {
                current = heightQueue.peek() * -1;
            }

            if(prevHeight != current) {
                int[] a = {p.x, current};
                result.add(a);
                prevHeight = current;
            }
        }

        return result;
    }

    /**
     * Slow version: Check for all possible points in left-up corner, bottom-down cornor and merge points.
     * Time Limit Exceeded!
     *
     * Time: O(n^3) in worst cases
     */
    public List<int[]> getSkyline_slow(int[][] b) {
        List<int[]> result = new ArrayList();
        if(b.length == 0) {
            return result;
        }

        // Use set to avoid adding duplicated points
        Set<Point> set = new HashSet<Point>();
        int n = b.length;
        for(int i=0;i<n;i++) {
            int l = b[i][0];
            int r = b[i][1];
            int h = b[i][2];
            // Left-up point
            set.add(new Point(l, h));
            // Right-bottom point
            set.add(new Point(r, 0));

            for(int j=0;j<n;j++) {
                if(i != j) {
                    int r2 = b[j][1];
                    int h2 = b[j][2];
                    if(h2 > h && r2 > l && r2 < r) {
                        set.add(new Point(r2, h));
                    }
                }
            }
        }

        PriorityQueue<Point> q = new PriorityQueue<Point>(set);
        while(!q.isEmpty()) {
            Point p = q.poll();
            boolean flag = true;
            // check if this point is hidden by any rectangle(other than itself)
            for(int i=0;i<n;i++) {
                int l = b[i][0];
                int r = b[i][1];
                int h = b[i][2];
                if(p.x >= l && p.x < r && p.y < h) {
                    flag = false;
                }
            }

            if(flag) {
                int[] a = {p.x, p.y};
                result.add(a);
            }
        }

        return result;
    }

    class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }
            if(!(o instanceof Point)) {
                return false;
            }
            Point p = (Point)o;
            return x == p.x && y == p.y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public int compareTo(Point p) {
            // Order by x
            if(this.x < p.x) {
                return -1;
            } else if(this.x == p.x) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
