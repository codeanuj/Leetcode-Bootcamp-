class Solution {
  
    public int minFallingPathSum(int[][] matrix) {
        int min =Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                dp[i][j]=-1;
      
      /*To find which column we should start */
        for(int i=0; i<matrix[0].length; i++){
           min=Math.min(min, findMinFallingPathSum(0, i, matrix, dp));
        }
        return min;
    }
    
    private int findMinFallingPathSum(int curr_row, int curr_col, int [][] matrix, int[][] dp){
        
        if(curr_row==matrix.length-1 && (curr_col>=0 && curr_col<matrix[0].length)) return matrix[curr_row][curr_col];
        
        if(curr_row>=matrix.length || curr_col>=matrix[0].length || curr_col <0) return 10001;
        
        if(dp[curr_row][curr_col] != -1) return dp[curr_row][curr_col];
        
      /* Three Moves as given in question */
        int moveDown = matrix[curr_row][curr_col] + findMinFallingPathSum(curr_row+1, curr_col, matrix, dp);
        int moveRight = matrix[curr_row][curr_col] + findMinFallingPathSum(curr_row+1, curr_col+1, matrix, dp);
        int moveLeft = matrix[curr_row][curr_col] + findMinFallingPathSum(curr_row+1, curr_col-1, matrix, dp);
        
        
        dp[curr_row][curr_col] = Math.min(moveRight, Math.min(moveLeft, moveDown));
        return dp[curr_row][curr_col];
    }
}
