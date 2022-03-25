class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp = new int[price.length][n+1];
        
        for(int i=0; i<price.length; i++)
           for(int j=0; j<=n; j++)
              dp[i][j]=-1;
            
        return getMaxProfit(0, price, n, dp);
    }
    
    private int getMaxProfit(int curr_index, int[] price, int length, int[][] dp){
        
        if(length==0 || curr_index>=price.length) return 0;
        
        if(dp[curr_index][length] !=-1) return dp[curr_index][length];
        
        int consider = 0;
        
        if(length>= (curr_index+1))
           consider= price[curr_index]+ getMaxProfit(curr_index, price, length-(curr_index+1), dp);
           
        int notConsider = getMaxProfit(curr_index+1, price, length, dp);
        
        dp[curr_index][length] = Math.max(consider, notConsider);
        
        return dp[curr_index][length];
        
        
        
    }
}
