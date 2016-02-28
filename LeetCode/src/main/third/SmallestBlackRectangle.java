package third;

import java.util.LinkedList;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e.,
 * there is only one black region. Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses
 * all black pixels.
 *
 For example, given the following image:
 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2, Return 6.
 */
public class SmallestBlackRectangle {
    /**
     * DFS to find most top, botton, left and right positions.
     *
     * Time: O(m*n)
     */
    int minArea(char[][] a, int x, int y) {
        int m = a.length;
        int n = a[0].length;

        int minX = x;
        int maxX = x;
        int minY = y;
        int maxY = y;

        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> q=  new LinkedList();
        q.add(new int[] { x, y});
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            if(i>=0 && i<m && j>=0 && j<n && !visited[i][j] && a[i][j] == '1'){
                visited[i][j] = true;
                minX = Math.min(minX, i);
                maxX = Math.max(maxX, i);
                minY = Math.min(minY, j);
                maxY = Math.max(maxY, j);

                int[][] positions = {{i-1,j}, {i+1,j}, {i, j-1}, {i,j+1}};
                for(int[] pos: positions) q.add(pos);
            }
        }

        return (maxX-minX+1)*(maxY-minY+1);
    }

    /**
     * Binary search to find the most top, bottom, left and right with 1 in matrix.
     *
     * Time: O(m*lgn + n*lgm)
     */
}
