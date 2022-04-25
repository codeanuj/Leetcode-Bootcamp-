class Solution {
    public boolean canArrange(int[] arr, int k) {
        
      //for k we can have elements 0 to k-1
        int[] memo = new int[k];
        //calculate frequency of remainder
        for(int currentVal:arr){
            int remainder = ((currentVal%k)+k)%k;
            memo[remainder] +=1;
        }
        
        if(memo[0]%2 != 0) return false;
             //check whether frequency is same or not
        for(int i=1; i<=k/2; i++){
                int y = k-i;
                if(memo[y] != memo[i])
                    return false;
        }
        
        return true;
    }
}
