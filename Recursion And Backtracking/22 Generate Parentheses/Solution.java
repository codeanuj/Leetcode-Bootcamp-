class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(0, 0, n, new StringBuilder());
        return result;
    }

    private void generateParenthesis(int openCount, int closeCount, int n, StringBuilder answer){
        if(openCount == closeCount && openCount == n){
            result.add(answer.toString());
            return;
        }

        if(openCount < n){
            generateParenthesis(openCount+1, closeCount, n, answer.append("("));
            answer.deleteCharAt(answer.length()-1);
        }     
        

        if(closeCount < openCount){
            generateParenthesis(openCount, closeCount+1, n, answer.append(")"));
            answer.deleteCharAt(answer.length()-1);
        }
        return;
    }
}
