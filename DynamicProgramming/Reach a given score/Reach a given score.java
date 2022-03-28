
class Geeks {
    public long count(int n) {
        
        int[] nums={3,5,10};
        int[][] dp=new int[nums.length][n+1];
        
        for(int i=0; i<nums.length; i++)
           for(int j=0; j<=n; j++)
               dp[i][j]=-1;
        return getNoOfWays(0, n, nums, dp);
    }
    
    private int getNoOfWays(int curr_index, int target, int[] nums, int[][] dp){
        
        if(target==0) return 1;
        if(curr_index>=nums.length) return 0;
        
        if(dp[curr_index][target] != -1) return dp[curr_index][target]; 
          consider= getNoOfWays(curr_index, target-nums[curr_index], nums, dp);
           
        int notConsider=getNoOfWays(curr_index+1, target, nums, dp);
        dp[curr_index][target]= consider+notConsider;
        return dp[curr_index][target];
    }
}
