class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp=new int[coins.length][amount+1];
        
        for(int i=0; i<coins.length; i++)
            for(int j=0; j<=amount; j++)
                dp[i][j]=-1;
       
        return findNumberOfWays(0,amount,coins,dp);
    }
    
    private int findNumberOfWays(int curr_index, int amount, int[] coins, int[][] dp){
        
        if(amount==0) return 1;
        if(curr_index >= coins.length) return 0;
        
        if(dp[curr_index][amount]!=-1) return dp[curr_index][amount];
        
        int consider=0;
        
        if(coins[curr_index]<=amount)
            consider = findNumberOfWays(curr_index, amount-coins[curr_index], coins, dp);
        
        int notConsider = findNumberOfWays(curr_index+1, amount, coins, dp);
        
        dp[curr_index][amount]= consider+notConsider;
        
        return dp[curr_index][amount];
    }
}
