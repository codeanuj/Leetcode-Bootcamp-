class Solution {
    public int minFallingPathSum(int[][] grid) {
      
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j]=-1;
        
        int result = Integer.MAX_VALUE;
        /*two adjacent row should not pick value from same column so initially our prev_col=-1 for 0th row*/
        int ans = getMinFallingPathSum(0, -1, m, n, grid, dp);
        return ans;
            
   }
   
    private int getMinFallingPathSum(int curr_row, int prev_col, int m, int n, int[][] grid, int[][] dp){
       
      /* we are already taking value curr_row==m-1, col into account */
        if(curr_row == m) return 0;
        
        if(prev_col != -1 && dp[curr_row][prev_col] != -1) return dp[curr_row][prev_col];
        
        int ans = Integer.MAX_VALUE;
      /*Need to check for all the column accept previous column*/
      /*Whichever coulmn we choose it will be a previous column for next row */
        for(int col=0; col<n; col++){
            if(col == prev_col) continue;
            int move = grid[curr_row][col] + getMinFallingPathSum(curr_row+1, col, m, n, grid, dp);
            ans = Math.min(ans, move);
        }
        if(prev_col!=-1) dp[curr_row][prev_col] =ans;
        return ans;
        
    }
}
    
