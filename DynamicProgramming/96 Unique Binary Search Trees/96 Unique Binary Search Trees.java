class Solution {
    public int numTrees(int n) {
        /*It is an application of catalan number*/
        return numberOfUniqueBST(n, new HashMap<Integer, Integer>());
    }
    
    private int numberOfUniqueBST(int n, HashMap<Integer, Integer> map){
        if(n==0 || n==1) return 1;
        
        int curr_key= n;
        
        if(map.containsKey(curr_key)) return map.get(curr_key);
        int noOfTree=0;
        for(int i=0; i<n; i++){
           noOfTree+= (numberOfUniqueBST(i, map) * numberOfUniqueBST(n-i-1, map));
        }
        
        map.put(curr_key, noOfTree);
        return map.get(curr_key);
    }
}
