class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++)
            for(int j=0; j<word2.length(); j++)
                dp[i][j] = -1;
        return getMinOperation(0, 0, word1, word2, dp);
    }
    
    private int getMinOperation(int i, int j, String word1, String word2, int[][] dp){
        /* if one string end than you need to delete all the remaining characters from other string */
        if(i>=word1.length()) return word2.length()-j;
        if(j>=word2.length()) return word1.length()-i;
        
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        /* if both chars are equal no need to do anything(0 operation) */
        if(word1.charAt(i) == word2.charAt(j)){
            ans = getMinOperation(i+1, j+1, word1, word2, dp);
        }else{
          /* if insert than need to compare with second string index
             if delete operation perform on first string move the index
             if replace done move both index as the characters are similar now */
            int insert = 1 + getMinOperation(i, j+1, word1, word2, dp);
            int delete = 1 + getMinOperation(i+1, j, word1, word2, dp);
            int replace = 1 + getMinOperation(i+1, j+1, word1, word2, dp);
            /* take out minimum of three operation and add in answer */
            int k = Math.min(insert, Math.min(delete, replace));
            ans+=k;
        }
        
        dp[i][j] = ans;
        return ans;
    }
}

