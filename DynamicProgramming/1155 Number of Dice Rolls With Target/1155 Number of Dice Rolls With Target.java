class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=target; j++)
                dp[i][j]=-1;
        
        
        return getNumberOfWays(n, k, target, dp);
    }
    
    private int getNumberOfWays(int dice, int face, int target, int[][] dp){
        
        if(dice == 0 && target == 0) return 1;
        if(target<=0 || dice ==0) return 0;
        if(dp[dice][target] != -1) return dp[dice][target];
        
        int MOD = 1000000007;
            
        int ways=0;
        /*one dice has as much choice as face value*/
        for(int roll = 1; roll<=face; roll++){
            int tempWays = (getNumberOfWays(dice-1, face, target-roll, dp)) % MOD;
            ways = (ways%MOD + tempWays%MOD) % MOD;
        }
        
        dp[dice][target]= ways;
        return dp[dice][target];
    }
}
