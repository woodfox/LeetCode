package third;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.

 Follow up:
 Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {
    public void gameOfLife(int[][] a) {
        int m = a.length;
        if(m == 0) return;
        int n = a[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x = check(a, i, j);
                if(a[i][j] == 1) {
                    if(x > 3 || x < 2){
                        a[i][j] = 2;
                    }
                } else if(x == 3){
                    a[i][j] = -1;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 2) {
                    a[i][j] = 0;
                } else if (a[i][j] == -1) {
                    a[i][j] = 1;
                }
            }
        }
    }

    private int check(int[][] a, int row, int col) {
        int[][] rules = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int m = a.length;
        int n = a[0].length;

        int count = 0;
        for(int[] r : rules) {
            int x = r[0];
            int y = r[1];
            if(row+x >= 0 && row+x < m && col+y>=0 && col+y<n && a[row+x][col+y] > 0){
                count++;
            }
        }
        return count;
    }
}
