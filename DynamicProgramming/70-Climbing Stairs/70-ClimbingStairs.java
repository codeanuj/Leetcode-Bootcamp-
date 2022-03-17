class Solution {
    public int climbStairs(int n) {
        
        return calculateWays(0,n, new HashMap<Integer, Integer>());
    }
    
    private int calculateWays(int curr_stair, int target_stair, HashMap<Integer, Integer> map){
        
        /* current stair is being equal to target stair means we are reached and this is one of the way so return 1*/
        if(curr_stair == target_stair) return 1;
        
        /* current stair is being greater than target stair means we are a step ahead so we can not return back so return         0*/
        if(curr_stair > target_stair) return 0;
        
        
        int current_key = curr_stair;
        
        if(map.containsKey(current_key))
            return map.get(current_key);
        
        int a = calculateWays(curr_stair+1, target_stair, map);
        int b = calculateWays(curr_stair+2, target_stair, map);
        
        map.put(current_key,(a+b));
        return (a+b);
        
    }
    //TC = O(n) key can reach maximum n value
}
