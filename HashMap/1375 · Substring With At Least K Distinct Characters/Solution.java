public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        long n= s.length();
        long totalSubstring = (n*(n+1))/2;
        return totalSubstring-getCountOfAtMostKMinusOneString(s, k-1);

    }

    private long getCountOfAtMostKMinusOneString(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int release = 0;
        int distinct = 0;
        long result = 0;

        for(int acquire=0; acquire<s.length(); acquire++){
            Character acquiredCharacter = s.charAt(acquire);
            if(map.containsKey(acquiredCharacter)){
                map.put(acquiredCharacter, map.get(acquiredCharacter)+1);
            }else{
                map.put(acquiredCharacter,1);
                distinct+=1;
            }
            while(release<=acquire && distinct>k){
                Character discardCharacter = s.charAt(release);
                release+=1;
                map.put(discardCharacter, map.get(discardCharacter)-1);

                if(map.get(discardCharacter)==0){
                    map.remove(discardCharacter);
                    distinct-=1;
                }
            }

            result += (acquire-release+1);
        }
        return result;
    }
}
