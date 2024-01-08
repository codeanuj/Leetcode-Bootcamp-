public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int release = 0;
        int length =0;
        int distinct=0;

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
                map.put(discardedCharacter, map.get(discardedCharacter)-1);
                release+=1;

                if(map.get(discardedCharacter)==0){
                    map.remove(discardedCharacter);
                    distinct-=1;
                }
            }
            length= Math.max(length, acquire-release+1);
        }
        return length;
    }
}
