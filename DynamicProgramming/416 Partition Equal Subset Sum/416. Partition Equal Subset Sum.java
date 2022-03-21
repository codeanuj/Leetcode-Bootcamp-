class Solution {
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int i : nums)
            s+=i;
        
        if(s%2!=0) return false;
        
        return findSubSetPartition(0, s/2, nums, new HashMap<String, Boolean>());   
    }
    
    private boolean findSubSetPartition(int curr_index, int targetSum, int[] nums, HashMap<String, Boolean> map){
        
        if(targetSum==0) return true;
        
        if(curr_index>=nums.length) return false;
        
        String curr_key= curr_index+"-"+targetSum;
        
        if(map.containsKey(curr_key)) return map.get(curr_key);
        
        boolean consider=false;
        
        if(targetSum>=nums[curr_index]){
            consider= findSubSetPartition(curr_index+1, targetSum-nums[curr_index], nums, map);
            if(consider){
                map.put(curr_key, consider);
                return consider;
            }
        }
        boolean notConsider= findSubSetPartition(curr_index+1, targetSum, nums, map);
        
        map.put(curr_key, (consider || notConsider));
        return map.get(curr_key);
    }
}
