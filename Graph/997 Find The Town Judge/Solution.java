class Solution {
    public int findJudge(int n, int[][] trust) {
     int[] inDegree = new int[n+1];
     int[] outDegree = new int[n+1];

     for(int[] current : trust){
        int x = current[0];
        int y= current[1];

        outDegree[x] +=1;
        inDegree[y]+=1;
        
     }

     for(int i=1; i<=n; i++){
        if(inDegree[i] ==  n-1 && outDegree[i] == 0) return i;
     }   

     return -1;
    }
}
