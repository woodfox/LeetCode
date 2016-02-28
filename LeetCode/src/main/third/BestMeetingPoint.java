package third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 For example, given three people living at (0,0), (0,4), and (2,2):

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

 Hint
 Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */
public class BestMeetingPoint {
    /**
     * In one dimension, the bes location is always the median position.
     * In two dimension, it's similar for row and cols.
     *
     * Time: O(m*n)
     */
    public int minTotalDistance(int[][] a){
        if(a.length == 0) return -1;

        List<Integer> rows = new ArrayList();
        List<Integer> cols = new ArrayList();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] == 1){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        int x = findMedian(rows);
        int y = findMedian(cols);
        int dist = 0;
        for(int row: rows) {
            dist += Math.abs(row - x);
        }
        for(int col : cols) {
            dist += Math.abs(col - y);
        }
        return dist;
    }

    private int findMedian(List<Integer> l) {
        Collections.sort(l);
        int n = l.size();
        return l.get((n+1)/2 - 1);
    }

    /**
     * A slower version using BFS to calculate min distance for every position.
     *
     * Time: O(k*m*n), k is total number of homes.
     */
    public int minTotalDistance_slow(int[][] a) {
        if (a.length == 0) return -1;
        int m = a.length;
        int n = a[0].length;
        int[][] r = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1) {
                    boolean[][] visited = new boolean[m][n];
                    LinkedList<int[]> q = new LinkedList();
                    q.add(new int[] { i, j, 0});
                    bfs(q, visited, r);
                }
            }
        }

        int dist = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist = Math.min(dist, r[i][j]);
            }
        }

        return dist;
    }

    private void bfs(LinkedList<int[]> q, boolean[][] visited, int[][] r) {
        int m = r.length;
        int n = r[0].length;
        while(!q.isEmpty()) {
            int[] a = q.removeFirst();
            int x = a[0];
            int y = a[1];
            int dist = a[2];

            if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]){
                r[x][y] += dist;
                visited[x][y] = true;

                int[][] rules = {{-1,0}, {1,0}, {0, -1}, {0,1}};
                for(int[] rule: rules) {
                    q.add(new int[] {x+rule[0], y+rule[1], dist+1});
                }
            }
        }
    }
}
