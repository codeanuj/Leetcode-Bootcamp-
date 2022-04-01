class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = -1;
        return getMinOperation(0, 0, m ,n, word1, word2, dp);
    }
    
    private int getMinOperation(int i, int j, int m ,int n, String word1, String word2, int[][] dp){
        /* index of any string is getting bigger or  equal to the length means you need to delete remaining all character from string*/
        if(i >= m) return n-j;
        if(j >= n) return m-i;
        if(dp[i][j] != -1) return dp[i][j];
        int ans= 0;
        /* if character matches means no operation*/
        if(word1.charAt(i) == word2.charAt(j)){
             ans = getMinOperation(i+1, j+1, m, n, word1, word2, dp);
        }else{
          /* if character does not match means one operation as well as two choices */
            int a = 1 + getMinOperation(i+1, j, m, n, word1, word2, dp);
            int b = 1 + getMinOperation(i, j+1, m, n, word1, word2, dp);
            
            ans = Math.min(a, b);
        }
        dp[i][j] = ans;
        return ans;
    }
}
