class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int[][] dp = new int[prices.length][2];
        
        for(int i=0; i<prices.length; i++)
            for(int j=0; j<2; j++)
                dp[i][j]=-1;
        
        return getMaxProfitWithFee(0, prices, 1, fee, dp);
    }
    
    private int getMaxProfitWithFee(int curr_day, int[] prices, int canBuy, int fee, int[][] dp){
        
        if(curr_day >= prices.length) return 0;
        
        if(dp[curr_day][canBuy] != -1) return dp[curr_day][canBuy];
        
        int idle = getMaxProfitWithFee(curr_day+1, prices, canBuy, fee, dp);
        int ans=0;
            
        if(canBuy==1){
            int buy= -prices[curr_day]+ getMaxProfitWithFee(curr_day+1, prices, 0, fee, dp);
            ans = Math.max(idle, buy);
        }else{
            int sell= (prices[curr_day]-fee)+ getMaxProfitWithFee(curr_day+1, prices, 1, fee, dp);
            ans= Math.max(idle, sell);
        }
        
        dp[curr_day][canBuy] = ans;
        return dp[curr_day][canBuy];
    }
}
