class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int m = s.length();
        int[][] dp = new int[m][m];
            
        for(int i=0; i<m; i++)
            for(int j=0; j<m; j++)
                dp[i][j] = -1;
        /*if you take longest common subsequence of string and its reverse, it will be longest palindromic subsequence of that string*/
        return findLongestPalindromeSubsequence(0, 0, m, s, new StringBuilder(s).reverse().toString(), dp);
        
    }
    
    private int findLongestPalindromeSubsequence(int i, int j, int m, String s1, String s2,int[][] dp){
        
        if( i>= m || j>= m) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        
        if(s1.charAt(i) == s2.charAt(j)){
           ans = 1 + findLongestPalindromeSubsequence(i+1, j+1, m, s1, s2, dp);
        }else{
            int a = findLongestPalindromeSubsequence(i+1, j, m, s1, s2, dp);
            int b = findLongestPalindromeSubsequence(i, j+1, m, s1, s2, dp);
            
            ans = Math.max(a, b);
        }
        
        dp[i][j] = ans;
        return ans;
    }
}
