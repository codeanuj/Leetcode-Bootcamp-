class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return findWaysToGetTargetSum(0, nums, target, new HashMap<String, Integer>());
    }
    
    private int findWaysToGetTargetSum(int curr_index, int[] nums, int target, HashMap<String, Integer> map){
        
        if(curr_index==nums.length && target==0) return 1;
        if(curr_index==nums.length) return 0;
        
        String curr_key=Integer.toString(curr_index)+"-"+Integer.toString(target);
        
        if(map.containsKey(curr_key)) return map.get(curr_key);
      
        /* Either you can use + or -*/
        int a=findWaysToGetTargetSum(curr_index+1, nums, target-nums[curr_index], map);
        int b=findWaysToGetTargetSum(curr_index+1, nums, target+nums[curr_index], map);
        
        map.put(curr_key, (a+b));
        
        return map.get(curr_key);
    }
}
