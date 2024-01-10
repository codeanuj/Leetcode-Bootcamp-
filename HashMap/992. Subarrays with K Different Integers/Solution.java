class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int countOfAtMostK = countSubarraysForDistinctIntegers(nums, k);
        int countOfAtMostKMinusOne = countSubarraysForDistinctIntegers(nums, k-1);
        return countOfAtMostK-countOfAtMostKMinusOne;
        
    }

    private int countSubarraysForDistinctIntegers(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int release=0;
        int distinct=0;
        int result=0;

        for(int acquire=0; acquire<nums.length; acquire++){
            int acquiredInteger=nums[acquire];

            if(map.containsKey(acquiredInteger)){
                map.put(acquiredInteger, map.get(acquiredInteger)+1);
            }else{
                map.put(acquiredInteger, 1);
                distinct+=1;
            }

            while(release<=acquire && distinct>k){
                int discardInteger=nums[release];
                release+=1;
                map.put(discardInteger, map.get(discardInteger)-1);
                if(map.get(discardInteger)==0){
                    map.remove(discardInteger);
                    distinct-=1;
                }
            }
            result+=(acquire-release+1);
        }
        return result;
    }
}
