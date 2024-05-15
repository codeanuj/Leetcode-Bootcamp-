class Solution {
    List<String> answer = new ArrayList<>();
    String[] KEYS_MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return answer;
        letterCombinations(digits, 0, new StringBuilder());
        return answer;        
    }

    private void letterCombinations(String digits, int curr_index, StringBuilder combination){
        if(curr_index >= digits.length()){
            answer.add(combination.toString());
            return;
        }
        char number = digits.charAt(curr_index);
        String alphabet = KEYS_MAPPING[number - '0'];
        for(int i=0; i<alphabet.length(); i++){
            combination.append(alphabet.charAt(i));
            letterCombinations(digits, curr_index+1, combination);
            combination.deleteCharAt(combination.length()-1);
        }
        return;
    }
}
