class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(calculateCost(0,cost, new HashMap<Integer, Integer>()), 
                        calculateCost(1,cost, new HashMap<Integer, Integer>()));
    }
    
    private int calculateCost(int current_index, int[] cost, HashMap<Integer, Integer> map){
     
        if(current_index==cost.length) return 0;
        
      //max value to return
        if(current_index>cost.length) return 1000;
        
        int current_key=current_index;
        
        if(map.containsKey(current_key)) return map.get(current_key);
        
        int oneStep= cost[current_index] + calculateCost(current_index+1, cost, map);
        int twoStep= cost[current_index] + calculateCost(current_index+2, cost, map);
        
        map.put(current_key, Math.min(oneStep, twoStep));
        return map.get(current_key);
    }
}
