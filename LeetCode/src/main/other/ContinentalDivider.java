package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个矩阵，其中0代表海洋，其他数字代表高度。秉着水往低处流的原则，求出能够流向任意海洋的点。 比如说

 0 0 0 1 2 3 0
 0 1 2 2 4 3 2
 2 1 1 3 3 2 0
 0 3 3 3 2 3 3

 那么就要给出 第二行的4 （这有这点出发，能够找到连通道四个0的区域的一条非递增
 路线），当然也有可能找不到这样的点，或者找到多个点。
 */
public class ContinentalDivider {
    public List<Integer> find(int[][] a) {
        List<Integer> r = new ArrayList();

        int m = a.length;
        if(m==0 || a[0].length==0) return r;
        int n = a[0].length;

        int[][] count = new int[m][n];
        int total = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 0){
                    total++;
                    boolean[][] visited = new boolean[m][n];
                    dfs(a, i, j, count, visited);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(count[i][j] == total && a[i][j] != 0) {
                    r.add(a[i][j]);
                }
            }
        }
        return r;
    }

    private void dfs(int[][] a, int i, int j, int[][] count, boolean[][] visited) {
        visited[i][j] = true;
        count[i][j]++;
        int m = a.length;
        int n = a[0].length;
        int[][] path = new int[][] {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
        for(int[] p : path) {
            int x = p[0];
            int y = p[1];
            if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && a[x][y] >= a[i][j]) {
                dfs(a, x, y, count, visited);
            }
        }
    }
}
