class Solution {
    public int minPathSum(int[][] grid) {
      
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++) 
            for(int j=0; j<grid[0].length; j++)
                dp[i][j]=-1;
        return findMinPath(0, 0, grid.length, grid[0].length, grid, dp);     
    }
    
    private int findMinPath(int curr_row, int curr_col, int m, int n, int[][] grid, int[][] dp){
        
        if(curr_row == m-1 && curr_col==n-1) return grid[curr_row][curr_col];
        if(curr_row >= m || curr_col >= n) return 10001;
        if(dp[curr_row][curr_col] != -1) return dp[curr_row][curr_col];
        /*Move in right or down direction only*/
        int rightMove = grid[curr_row][curr_col] + findMinPath(curr_row, curr_col+1, m, n, grid, dp);
        int downMove = grid[curr_row][curr_col] + findMinPath(curr_row+1, curr_col, m, n, grid, dp);
        
        dp[curr_row][curr_col] = Math.min(rightMove, downMove);
        return dp[curr_row][curr_col];
    }
}
