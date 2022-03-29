class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
              
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int i=0; i<obstacleGrid.length; i++)
            for(int j=0; j< obstacleGrid[0].length; j++)
                dp[i][j]=-1;
        
        return getUniquePath(0, 0, obstacleGrid.length, obstacleGrid[0].length, obstacleGrid, dp);
        
    }
    
    private int getUniquePath(int curr_row, int curr_col, int m, int n, int[][] grid, int[][] dp){
        
      /* if curr_row and column contains one then it's a boacker */
        if(curr_row>= m || curr_col>= n || grid[curr_row][curr_col] == 1) return 0;
      
        if(curr_row == m-1 && curr_col == n-1 ) return 1;
      
        if(dp[curr_row][curr_col] != -1) return dp[curr_row][curr_col];
      
        int rightMove = getUniquePath(curr_row, curr_col+1, m, n, grid, dp);
        int downMove = getUniquePath(curr_row+1, curr_col, m, n, grid, dp);
      
        dp[curr_row][curr_col]=rightMove+downMove;
      
        return rightMove+downMove;
    }
}
