class Solution {
    public int maxProfit(int[] prices) {
              
        int[][][] dp =new int[prices.length][2][2];
        
        for(int i=0; i<prices.length; i++)
            for(int j=0; j<2; j++)
                for(int k=0; k<2; k++)
                    dp[i][j][k]=-1;
        return getMaxProfitWithOneTransaction(0, prices, 1, 1, dp);
               
    }
    
    private int getMaxProfitWithOneTransaction(int curr_day, int[] prices, int canBuy, int transCount, int[][][]dp){
        if(curr_day>=prices.length || transCount==0) return 0;
        
        if(dp[curr_day][canBuy][transCount] != -1) return dp[curr_day][canBuy][transCount];
        
        int ans=0;
        
        if(canBuy==1){
            int idle = getMaxProfitWithOneTransaction(curr_day+1, prices, canBuy, transCount, dp);
            int buy = -prices[curr_day] + getMaxProfitWithOneTransaction(curr_day+1, prices, 0, transCount, dp);
            ans = Math.max(idle, buy);
            
        }else{
            int idle = getMaxProfitWithOneTransaction(curr_day+1, prices, canBuy, transCount, dp);
            int sell = prices[curr_day] +getMaxProfitWithOneTransaction(curr_day+1, prices, 1, transCount-1, dp);
            ans = Math.max(idle, sell);
        }
        
        dp[curr_day][canBuy][transCount] = ans;
        return dp[curr_day][canBuy][transCount];
    }
}

// 2nd Approach
 /*  int min=Integer.MAX_VALUE;
      int profit=0;
      
        //you will just assume that you sell the stock on everyday and find the difference between current day
        //and the minimum you have seen before current day
        
        for(int i=0; i<prices.length; i++){
            
            min =Math.min(min, prices[i]);
            profit= Math.max(profit, prices[i]-min);
        }
        
        return profit; */
