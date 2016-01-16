package third;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;
        for(int length=0;length<=Math.min(m-1, n-1)/2;length++){
            int upRow = length;
            int bottomRow = m - length - 1;
            int leftCol = length;
            int rightCol = n - length - 1;
            if(upRow == bottomRow) {
                for(int i=leftCol;i<=rightCol;i++) result.add(matrix[upRow][i]);
            }else if(leftCol == rightCol) {
                for(int i=upRow;i<=bottomRow;i++) result.add(matrix[i][leftCol]);
            }else{
                for(int i=leftCol;i<rightCol;i++) result.add(matrix[upRow][i]);
                for(int i=upRow;i<bottomRow;i++) result.add(matrix[i][rightCol]);
                for(int i=rightCol;i>leftCol;i--) result.add(matrix[bottomRow][i]);
                for(int i=bottomRow;i>upRow;i--) result.add(matrix[i][leftCol]);
            }
        }
        return result;
    }
}
