class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findUniqueSubsets(0, nums, new ArrayList<>());
        return answer;        
    }

    private void findUniqueSubsets(int curr_index, int[] nums, List<Integer> list){
        if(curr_index >= nums.length){
            if(!answer.contains(list))
               answer.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[curr_index]);
        findUniqueSubsets(curr_index+1, nums, list);
        list.remove(list.size()-1);
        findUniqueSubsets(curr_index+1, nums, list);
        return;
    }
}
