class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        int sum=0;
        int answer=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<N; i++){
            sum+=A[i];
            if(map.containsKey(sum-K)) answer = Math.max(answer, i-map.get(sum-K));
            
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        
        return answer;
    }
    
    
}
