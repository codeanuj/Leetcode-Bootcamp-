class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = -1; 
        return longestCommonSubsequence(0, 0, text1, text2, m, n, dp);
    }
    
    private int longestCommonSubsequence(int i, int j, String text1, String text2, int m, int n, int [][]dp){
      /* if index is out of bound i.e empty string can contribute 0 length*/
        if(i >= m || j >=n ) return 0;
      
        if(dp[i][j] != -1) return dp[i][j];
      
        int ans=0;
        /*both the characters are equal means they can contribute in result*/
        if(text1.charAt(i) == text2.charAt(j))
            ans = 1+ longestCommonSubsequence(i+1, j+1, text1, text2, m, n, dp);
        else{
          /* both are not equal, we will make two choice that either of them will contribute and will take max out of two*/
            int a= longestCommonSubsequence(i+1, j, text1, text2, m, n, dp);
            int b= longestCommonSubsequence(i, j+1, text1, text2, m, n, dp);
            
            ans= Math.max(a, b);
        }
        dp[i][j]=ans;
        return ans;
    }
}
