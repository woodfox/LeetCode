package third;

import java.util.LinkedList;

public class SurroundedRegions {
    /**
     *  BFS for all 'O' fields in outside edge and set to 'Z'.
     *  At last replace all 'O' to 'X', and 'Z' back to 'O';
     *
     *  DFS will throw RuntimeException!
     */
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            bfs(board, i, 0);
            bfs(board, i, n-1);
        }

        for(int i=0;i<n;i++){
            bfs(board, 0, i);
            bfs(board, m-1, i);
        }

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;

        LinkedList<Integer> rowQueue = new LinkedList<Integer>();
        LinkedList<Integer> colQueue = new LinkedList<Integer>();
        rowQueue.add(row);
        colQueue.add(col);

        while (!rowQueue.isEmpty()) {
            int r = rowQueue.removeFirst();
            int c = colQueue.removeFirst();

            if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
                continue;
            }

            board[r][c] = 'Z';

            addToQueue(r + 1, c, rowQueue, colQueue);
            addToQueue(r - 1, c, rowQueue, colQueue);
            addToQueue(r, c + 1, rowQueue, colQueue);
            addToQueue(r, c - 1, rowQueue, colQueue);
        }
    }

    private void addToQueue(int row, int col, LinkedList<Integer> rowQueue, LinkedList<Integer> colQueue) {
        rowQueue.add(row);
        colQueue.add(col);
    }
}
