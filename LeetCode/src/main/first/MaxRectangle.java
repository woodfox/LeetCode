package first;
public class MaxRectangle {
	//DP with O(n^3)
	//Get the largest rectangle based on point (i,j)
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0){
            return 0;
        }
        
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = matrix[i][j] - '0';
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(dp[i][j] > 0){
                    dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }
        
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int height = dp[i][j];
                for(int k=i;k>=0;k--){
                    height = Math.min(height, dp[k][j]);
                    if(dp[k][j] == 0){
                        break;
                    }
                    max = Math.max(max, height*(i-k+1));
                }
            }
        }
        return max;
    }
    
	// DP with O(n^5)
	//It could pass small data set, but will throw 
	//Memory Limit Exceeded error for large data set!!
	public int maximalRectangle1(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int h = matrix.length;
		if (h == 0) {
			return 0;
		}
		int w = matrix[0].length;
		int max = 0;

		boolean[][][][] dp = new boolean[h][w][h][w];
		for (int i = h - 1; i >= 0; i--) {
			for (int j = w - 1; j >= 0; j--) {
				for (int m = h - 1; m >= i; m--) {
					for (int n = w - 1; n >= j; n--) {
						if (i == m && j == n) {
							dp[i][j][m][n] = (matrix[i][j] == '1');
						} else if (i == m) {
							if (matrix[i][j] == '1' && dp[i][j + 1][m][n]) {
								dp[i][j][m][n] = true;
							}
						} else if (j == n) {
							if (matrix[i][j] == '1' && dp[i + 1][j][m][n]) {
								dp[i][j][m][n] = true;
							}
						} else if (dp[i + 1][j + 1][m][n]) {
							boolean flag = true;
							for (int x = j; x <= n; x++) {
								if (matrix[i][x] == '0') {
									flag = false;
									break;
								}
							}
							if (flag) {
								for (int y = i; y <= m; y++) {
									if (matrix[y][j] == '0') {
										flag = false;
										break;
									}
								}
							}
							if (flag) {
								dp[i][j][m][n] = true;
							}
						}
						if (dp[i][j][m][n] == true) {
							if (max < (m - i + 1) * (n - j + 1)) {
								max = (m - i + 1) * (n - j + 1);
							}
						}
					}
				}
			}
		}
		return max;
	}

	// Search with O(n^6)
	public int maximalRectangle2(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int h = matrix.length;
		if (h == 0) {
			return 0;
		}
		int w = matrix[0].length;
		int max = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				for (int m = i; m < h; m++) {
					for (int n = j; n < w; n++) {
						boolean flag = true;
						for (int x = i; x <= m; x++) {
							for (int y = j; y <= n; y++) {
								if (matrix[x][y] == '0') {
									flag = false;
									break;
								}
							}
						}
						if (flag) {
							if (max < (m - i + 1) * (n - j + 1)) {
								max = (m - i + 1) * (n - j + 1);
							}
						}
					}
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		MaxRectangle m = new MaxRectangle();
		char[][] matrix = {{'1','1'}};
		System.out.println(m.maximalRectangle(matrix));
	}
}
