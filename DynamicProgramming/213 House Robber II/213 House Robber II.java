class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        /* you can start either from 0 ot from 1,
        if you start from 0, you can till second last house 
        if you start from 1, you can go till the last house */
        return Math.max(getMaxAmountFromHouses(0, nums, nums.length-1, new HashMap<Integer, Integer>()),
                       getMaxAmountFromHouses(1, nums, nums.length, new HashMap<Integer, Integer>()));
        
    }
    
    private int getMaxAmountFromHouses(int curr_house, int[] nums, int n, HashMap<Integer, Integer> map){
        
        if(curr_house >= n) return 0;
        
        int curr_key = curr_house;
        if(map.containsKey(curr_key)) return map.get(curr_key);
        
        int rob = nums[curr_house] + getMaxAmountFromHouses(curr_house+2, nums, n, map);
        int notRob = getMaxAmountFromHouses(curr_house+1, nums, n, map);
        
        map.put(curr_key, Math.max(rob, notRob));
        return map.get(curr_key);
    }
}
