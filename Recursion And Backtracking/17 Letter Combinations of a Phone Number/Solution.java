class Solution {
    List<String> answer = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return answer;
        createPhone();
        letterCombinations(digits, 0, new StringBuilder());
        return answer;        
    }

    private void letterCombinations(String digits, int curr_index, StringBuilder combination){
        if(curr_index >= digits.length()){
            answer.add(combination.toString());
            return;
        }
        char number = digits.charAt(curr_index);
        String alphabet = map.get(number);
        for(int i=0; i<alphabet.length(); i++){
            combination.append(alphabet.charAt(i));
            letterCombinations(digits, curr_index+1, combination);
            combination.deleteCharAt(combination.length()-1);
        }
        return;
    }

    private void createPhone(){
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
