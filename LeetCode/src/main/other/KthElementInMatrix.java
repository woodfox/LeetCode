package other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElementInMatrix {
    /**
     * Use minHeap to get smallest numbers one by one and add their nearby numbers into minHeap.
     *
     * Time: O(klogk)
     */
    public  int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) return -1;
        int n = matrix[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue(10, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean[][] visited = new boolean[m][n];
        minHeap.add(new int[] {matrix[0][0], 0, 0});
        for(int i=1;i<k;i++){
            int[] min = minHeap.poll();
            int x = min[1];
            int y = min[2];

            if(x+1<m && !visited[x+1][y]) {
                visited[x+1][y] = true;
                minHeap.add(new int[] {matrix[x+1][y], x+1, y});
            }

            if(y+1<n && !visited[x][y+1]) {
                visited[x][y+1] = true;
                minHeap.add(new int[] {matrix[x][y+1], x, y+1});
            }
        }

        int[] result = minHeap.poll();
        return result[0];
    }

    /**
     * Use Max Heap to maintain kth elements.
     *
     * Time:  O(nlogk)
     */
    public  int kthSmallest_slow(int[][] matrix, int k) {
        int m = matrix.length;
        if(m==0 || matrix[0].length==0) return -1;
        int n = matrix[0].length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        for(int[] row : matrix){
            for(int val : row) {
                maxHeap.add(val);

                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}
