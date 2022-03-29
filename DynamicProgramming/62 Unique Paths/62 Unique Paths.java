class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j]=-1;
        
        return findUniquePaths(0, 0, m, n, dp);
    }
    
    private int findUniquePaths(int curr_row, int curr_col, int m, int n, int[][] dp){
      
        if(curr_row == m-1 && curr_col == n-1) return 1;
        if(curr_row >= m || curr_col >= n) return 0;
        if(dp[curr_row][curr_col]!=-1) return dp[curr_row][curr_col];
      /*Either you can move in right direction or down direction*/
        int rightMove = findUniquePaths(curr_row, curr_col+1, m, n, dp);
        int downMove = findUniquePaths(curr_row+1, curr_col, m, n, dp);
        
        dp[curr_row][curr_col] = rightMove+downMove;
        return rightMove+downMove;
    }
    
}
