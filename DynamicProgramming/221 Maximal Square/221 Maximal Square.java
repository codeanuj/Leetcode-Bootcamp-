class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int area=0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j]=-1;
        
      /* square can be start from any cell containing 1 */
        for(int curr_row=0; curr_row<m; curr_row++){
            for(int curr_col=0; curr_col<n; curr_col++){
                if(matrix[curr_row][curr_col] == '1'){
                    int length = getMaximalSquareArea(curr_row, curr_col, m, n, matrix, dp);
                    area= Math.max(area, length*length);
                }
            }
        }
        
        return area;
    }
    
    private int getMaximalSquareArea(int curr_row, int curr_col, int m, int n, char[][] matrix, int[][] dp){
        
        /* square should contain the only cells value with 1 */      
        if(curr_row < 0 || curr_row >= m || curr_col < 0 || curr_col >= n || matrix[curr_row][curr_col] == '0' )
            return 0;
        
        if(dp[curr_row][curr_col] != -1) return dp[curr_row][curr_col];
        
      /* we can either move in right direction, down direction and diagonal to make a square */
        int moveRight = Integer.parseInt(String.valueOf(matrix[curr_row][curr_col])) + getMaximalSquareArea(curr_row, curr_col+1, m, n, matrix, dp);
        int moveDown = Integer.parseInt(String.valueOf(matrix[curr_row][curr_col])) + getMaximalSquareArea(curr_row+1, curr_col, m, n, matrix, dp);
        int moveDiagonal = Integer.parseInt(String.valueOf(matrix[curr_row][curr_col]))+ getMaximalSquareArea(curr_row+1, curr_col+1, m, n, matrix, dp);
        
      /* will choose minimum of these three to make a perfect square */
        dp[curr_row][curr_col] = Math.min(moveRight, Math.min(moveDown, moveDiagonal));
        return dp[curr_row][curr_col];
    }
}
