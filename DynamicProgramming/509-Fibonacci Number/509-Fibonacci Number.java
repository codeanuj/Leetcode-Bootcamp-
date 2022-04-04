class Solution {
    public int fib(int n) {
        
        return calculateFib(n, new HashMap<Integer, Integer>());
    }
    
    private int calculateFib(int n, HashMap<Integer, Integer> map){
        
        if(n==0) return 0;
        if(n==1) return 1;
        
        int current_key=n;
        
        if(map.containsKey(current_key))
            return map.get(current_key);
        
        int a = calculateFib(n-1, map);
        int b = calculateFib(n-2, map);
        
        map.put(current_key, a+b);
        return a+b;
    }
}

//TC = O(n)
