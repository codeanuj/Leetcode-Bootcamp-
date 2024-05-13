class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(0, nums, new ArrayList<Integer>());
        return answer;
    }

    private void findSubsets(int index, int[] nums, List<Integer> currentList){
        if(index >= nums.length){
            answer.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[index]);
        findSubsets(index+1, nums, currentList);
        currentList.remove(currentList.size()-1);
        findSubsets(index+1, nums, currentList);
        return;
    }
}
