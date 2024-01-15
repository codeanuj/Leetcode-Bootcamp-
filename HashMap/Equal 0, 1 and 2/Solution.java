class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int countOfZero=0;
        int countOfOne=0;
        int countOfTwo=0;
        int result=0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("0#0", 1);
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '0') countOfZero++;
            else if(c == '1') countOfOne++;
            else countOfTwo++;
            int diffOne=countOfOne-countOfZero;
            int diffTwo=countOfTwo-countOfOne;
            String key = diffOne+"#"+diffTwo;
            
            if(map.containsKey(key)){
                result+=map.get(key);
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }
        return result;
    }
} 
