class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[][][] dp = new int[prices.length][2][k+1];
        
        for(int i=0; i<prices.length; i++)
            for(int j=0; j<2;j++)
                for(int l=0; l<=k; l++)
                    dp[i][j][l]=-1;
        /* K number of transactions are allowed */
        return getMaxprofitWithKTransaction(0, prices, 1, k, dp);
    }
    
    private int getMaxprofitWithKTransaction(int curr_day, int[] prices, int canBuy, int transCount, int[][][] dp){
        
        if(curr_day >= prices.length || transCount == 0) return 0;
        
        if(dp[curr_day][canBuy][transCount] != -1) return dp[curr_day][canBuy][transCount];
        
        int ans=0;
        
        int idle = getMaxprofitWithKTransaction(curr_day+1, prices, canBuy, transCount, dp);
        
        if(canBuy==1){
            int buy= -prices[curr_day]+ getMaxprofitWithKTransaction(curr_day+1, prices, 0, transCount, dp);
            ans=Math.max(idle, buy);
        }else{
            int sell = prices[curr_day] + getMaxprofitWithKTransaction(curr_day+1, prices, 1, transCount-1, dp);
            ans=Math.max(idle, sell);
        }
        
        dp[curr_day][canBuy][transCount] = ans;
        
        return dp[curr_day][canBuy][transCount];
    }
     
}
