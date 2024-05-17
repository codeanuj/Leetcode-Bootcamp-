class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int[] inDegree = new int[n];
    	int[] outDegree = new int[n];
    	
    	for(int i = 0; i < n; i++){
    	    for(int j = 0; j < n; j++){
    	        if(M[i][j]==1){
    	            inDegree[j] += 1;
    	            outDegree[i] += 1;
    	        }
    	    }
    	}
    	
    	for(int i=0; i<n; i++){
        if(inDegree[i] ==  n-1 && outDegree[i] == 0) return i;
     }   

     return -1;
    }
}//There is one more approach with two pointer O(n)
