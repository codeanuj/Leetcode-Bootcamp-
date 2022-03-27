class Solution {
    public int maxProfit(int[] prices) {
        
        int[][] dp =new int[prices.length][2];
        
        for(int i=0; i<prices.length; i++)
            for(int j=0; j<2; j++)
                dp[i][j]= -1;
        
        
        return getMaxProfitWithCooldown(0, prices, 1, dp);
    }
    
    private int getMaxProfitWithCooldown(int curr_day, int[] prices, int canBuy, int[][] dp){
        
        if(curr_day >= prices.length) return 0;
        
        if(dp[curr_day][canBuy] != -1) return dp[curr_day][canBuy];
        
        int idle= getMaxProfitWithCooldown(curr_day+1, prices, canBuy, dp);
        int ans=0;
        if(canBuy == 1){
            int buy = -prices[curr_day] + getMaxProfitWithCooldown(curr_day+1, prices, 0, dp);
            ans= Math.max(idle, buy);
        }else{/*one day cool down period after selling */
            int sell = +prices[curr_day] + getMaxProfitWithCooldown(curr_day+2, prices,1, dp);
            ans= Math.max(idle, sell);
        }
        
        dp[curr_day][canBuy] = ans;
        return dp[curr_day][canBuy];
    }
}
