class Solution {
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length][2];
        
        for(int i=0; i<prices.length; i++)
            for(int j=0; j<2; j++)
                dp[i][j]=-1;
        
        return getMaxProfit(0, prices, 1, dp);
    }
    
    private int getMaxProfit(int curr_day, int[] prices, int canBuy, int[][] dp){
        
        if(curr_day>=prices.length) return 0;
        
        if(dp[curr_day][canBuy] != -1) return dp[curr_day][canBuy];
        
        int ans=0;
        
        int idle = getMaxProfit(curr_day+1, prices, canBuy, dp);
        
        if(canBuy==1){
            int buy = -prices[curr_day] + getMaxProfit(curr_day+1, prices, 0, dp);
            ans = Math.max(idle, buy);
        }else{
            int sell = prices[curr_day] + getMaxProfit(curr_day+1, prices, 1, dp);
            ans = Math.max(idle, sell);
        }
        
        dp[curr_day][canBuy]=ans;
        return dp[curr_day][canBuy];
    }
}
