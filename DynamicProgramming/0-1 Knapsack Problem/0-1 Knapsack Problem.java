class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         return maxValue(0, W, wt, val, new HashMap<String,Integer>());
    } 
    
    private static int maxValue(int curr_index,int capacity,  int[] wt, int[] val, HashMap<String,Integer> map){
        
        if(curr_index==wt.length) return 0;
        
        String curr_key=Integer.toString(curr_index)+"-"+Integer.toString(capacity);
    
        if(map.containsKey(curr_key)) return map.get(curr_key);
        
        int consider=0;
        
        if(wt[curr_index]<= capacity)
          consider= val[curr_index] + maxValue(curr_index+1, capacity-wt[curr_index], wt, val, map);
          
        int notConsider=maxValue(curr_index+1, capacity, wt, val, map);
        
        map.put(curr_key, Math.max(consider, notConsider));
      
       return map.get(curr_key);
        
    }
}
