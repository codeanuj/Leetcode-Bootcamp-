class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer =0;
        int temp=0;
        for(int i=0; i<nums.length; i++){
            while(i<nums.length && nums[i]==1) {
                temp++;
                i++;
            }
            answer = Math.max(answer, temp);
            temp=0;

        }
        return answer;
    }
}
