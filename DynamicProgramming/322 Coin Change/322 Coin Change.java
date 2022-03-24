class Solution {
    public int coinChange(int[] coins, int amount) {
    
        int[][] dp =new int[coins.length][amount+1];
        
        /* Fill this array with -1 */
        for(int i=0; i<coins.length; i++)
            for(int j=0; j<=amount; j++)
                dp[i][j]=-1;
        
        int ans= getMinCoins(0, amount, coins, dp);
        
        if(ans==10001)
            return -1;
        
        return ans;
   }
    
    private int getMinCoins(int curr_index, int amount, int[] coins, int[][] dp){
        
        /* To get 0 amount we need 0 coin */
        if(amount==0) return 0;
        
        /* return the max value */
        if(curr_index>=coins.length) return 10001;
        
        if(dp[curr_index][amount] != -1) return dp[curr_index][amount];
        
        int consider=10001;
        
        if(coins[curr_index]<=amount)
            /* if considering the coin at any index then add 1 as you have used the coin*/
            consider=1+ getMinCoins(curr_index, amount-coins[curr_index], coins, dp);
        
        int notConsider= getMinCoins(curr_index+1, amount, coins, dp);
        
        dp[curr_index][amount]= Math.min(consider, notConsider);
        
        return dp[curr_index][amount];
        
    }
}
