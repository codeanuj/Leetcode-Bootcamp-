class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int release=0;
        int distinct=0;
        int answer = -1;
        
        for(int acquire=0; acquire<s.length(); acquire++){
            Character acquiredCharacter = s.charAt(acquire);
            
            if(map.containsKey(acquiredCharacter)){
                map.put(acquiredCharacter, map.get(acquiredCharacter)+1);
            }else{
                map.put(acquiredCharacter, 1);
                distinct+=1;
            }
            
            while(release<=acquire && distinct>k){
                Character discardedCharacter = s.charAt(release);
                release+=1;
                map.put(discardedCharacter, map.get(discardedCharacter)-1);
                if(map.get(discardedCharacter)==0){
                    map.remove(discardedCharacter);
                    distinct-=1;
                }
            }
            if(distinct == k)
              answer = Math.max(answer, acquire-release+1);
        }
        
        return answer;
        // code here
    }
}
