class Solution {

    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findCombimationSum(0, candidates, target, 0, new ArrayList<>());
        return answer;
    }

    private void findCombimationSum(int curr_index, int[] candidates, int target, int sum, List<Integer> list){
        if(curr_index >= candidates.length || sum>target) return;
       
        if(sum == target){
              answer.add(new ArrayList<>(list));
            return;
        } 
        
        list.add(candidates[curr_index]);
        findCombimationSum(curr_index, candidates, target, sum+candidates[curr_index], list);
        list.remove(list.size()-1);
        findCombimationSum(curr_index+1, candidates, target, sum, list);
        return;
    }
}
