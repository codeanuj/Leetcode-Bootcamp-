class Solution {
    public int rob(int[] nums) {
        return calculateMaxMoney(nums, 0, new HashMap<Integer, Integer>());
    }
    
   private int calculateMaxMoney(int[] nums, int current_house, HashMap<Integer, Integer> map){
        
       if(current_house >= nums.length) return 0;
       
       int current_key = current_house;
       
       if(map.containsKey(current_key)) return map.get(current_key);
       
       int rob = nums[current_house] + calculateMaxMoney(nums, current_house+2, map);
       int no_rob =  calculateMaxMoney(nums, current_house+1, map);
       
       map.put(current_key, Math.max(rob, no_rob));
       return map.get(current_house);
    }
}
