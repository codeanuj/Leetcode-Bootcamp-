class Solution {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        partition(s, 0, s.length(), new ArrayList<String>());
        return result;
    }
    private void partition(String s, int start, int end, List<String> answer){
        if(start >= end){
            result.add(new ArrayList<String>(answer));
            return;
        }

        for(int i = start; i < end; i++){
            String leftPart = s.substring(start, i+1);
            if(isPalindrome(leftPart)){
                answer.add(leftPart);
                partition(s, i+1, end, answer);
                answer.remove(answer.size()-1);
            }
        }

        return;
    }

    private boolean isPalindrome(String string){
        int start = 0;
        int end = string.length()-1;

        while(start<=end){
            if(string.charAt(start) != string.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
