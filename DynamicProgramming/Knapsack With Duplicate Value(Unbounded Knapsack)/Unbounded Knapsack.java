class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W+1];
        
        for(int i=0; i<N; i++)
           for(int j=0; j<=W; j++)
              dp[i][j]=-1;
        return getMaxValue(0, W, val, wt, dp);
    }
    
    private static int getMaxValue(int curr_index, int capacity, int[] val, int[] wt, int[][] dp){
        
        if(capacity==0 || curr_index>=val.length) return 0;
        
        if(dp[curr_index][capacity] != -1) return dp[curr_index][capacity];
        
        int consider=0;
        
        /* Either you can consider the element multiple times, so you will be on the same index */
        if(capacity>= wt[curr_index])
           consider = val[curr_index]+ getMaxValue(curr_index, capacity-wt[curr_index], val, wt, dp);
           
        /* you don't consider the current element*/   
        int notConsider = getMaxValue(curr_index+1, capacity, val, wt, dp);
        
        dp[curr_index][capacity] = Math.max(consider, notConsider);
        
        return dp[curr_index][capacity];
        

    }
}
