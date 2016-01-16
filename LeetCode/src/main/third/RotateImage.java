package third;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        int n = matrix.length;
        for(int length=0;length < n/2;length++){
            //DANGER: Only need to iterate from 0 to n-2!!
            for(int pos=length;pos<n-length-1;pos++){
                int temp = matrix[n-1-pos][length];
                matrix[n-1-pos][length] = matrix[n-length-1][n-1-pos];
                matrix[n-length-1][n-1-pos] = matrix[pos][n-length-1];
                matrix[pos][n-length-1] = matrix[length][pos];
                matrix[length][pos] = temp;
            }
        }
    }
}
