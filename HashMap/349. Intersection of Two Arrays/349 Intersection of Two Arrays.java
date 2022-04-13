class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
      
        ArrayList<Integer> list = new ArrayList();
        HashMap<Integer, Boolean> map = new HashMap();
        
        for(int i =0; i<nums1.length; i++){
            if(!map.containsKey(nums1[i]))
                map.put(nums1[i], true);
        }
      /*check whether nums2 value is present or not and if present than check whether we have added it previously*/  
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])  && map.get(nums2[i])){
                list.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}
