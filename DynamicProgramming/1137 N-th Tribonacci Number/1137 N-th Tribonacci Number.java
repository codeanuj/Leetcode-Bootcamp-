class Solution {
    public int tribonacci(int n) {
     return calculateTribonacci(n, new HashMap<Integer, Integer>());   
    }
    
    private int calculateTribonacci(int n, HashMap<Integer, Integer> map){
        
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        
        int current_key=n;
        
        if(map.containsKey(current_key)) return map.get(current_key);
        
        int a= calculateTribonacci(n-1, map);
        int b= calculateTribonacci(n-2, map);
        int c= calculateTribonacci(n-3, map);
        
        map.put(current_key, a+b+c);
        return map.get(current_key);
    }
}
