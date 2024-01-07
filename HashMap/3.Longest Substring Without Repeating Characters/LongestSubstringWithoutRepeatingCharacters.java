class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int release = 0;
        int result = 0;

        for(int acquire =0; acquire<s.length(); acquire++){
            Character curr_char = s.charAt(acquire);

            if(map.containsKey(curr_char) && map.get(curr_char)>=release) release = map.get(curr_char)+1;

            map.put(curr_char, acquire);
            result = Math.max(result, acquire-release+1);
            
        }   
        return result;
       
    }
    
}
