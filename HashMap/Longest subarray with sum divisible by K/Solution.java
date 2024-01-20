class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
        int sum=0;
        int answer=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0; i<n; i++){
            sum+=a[i];
            int curr_rem = ((sum%k)+k)%k;
            if(map.containsKey(curr_rem)) answer = Math.max(answer, i-map.get(curr_rem));
            else map.put(curr_rem, i);
            
        }
        return answer;
       
    }
 
}
