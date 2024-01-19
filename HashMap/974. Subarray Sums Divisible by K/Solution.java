class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int answer=0;
        map.put(0, 1);
        
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int curr_rem = ((sum % k) + k) % k;
            if(map.containsKey(curr_rem)) answer+=map.get(curr_rem);
            map.put(curr_rem, map.getOrDefault(curr_rem, 0)+1);
        }

        return answer;
    }
}
