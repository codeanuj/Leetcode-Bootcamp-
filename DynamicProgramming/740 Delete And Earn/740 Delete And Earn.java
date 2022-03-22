class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i: nums){
            if(i>max)
                max=i;
        }
        
        int[] freq=new int[max+1];
        
        for(int i=0; i<nums.length; i++){
            freq[nums[i]]++;
        }
        
        return getMaxPoints(0, freq,new HashMap<Integer,Integer>());
    }
    
    private int getMaxPoints(int curr_index, int[] freq,HashMap<Integer,Integer> map){
        
        if(curr_index>=freq.length) return 0;
        
        int curr_key=curr_index;
        
        if(map.containsKey(curr_key)) return map.get(curr_key);
        
        int consider= freq[curr_index]*curr_index + getMaxPoints(curr_index+2, freq, map);
        int notConsider= getMaxPoints(curr_index+1, freq, map);
        
        map.put(curr_key, Math.max(consider, notConsider));
        return map.get(curr_key);
    }
}
