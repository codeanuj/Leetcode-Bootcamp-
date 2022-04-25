class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        HashMap<Integer, Integer> map = new HashMap();
      //to handle the edge case
        map.put(0, -1);
        int length = 0;
        int prefixSum = 0;
        
        for(int i=0; i<N; i++){
            // if 0 treat it as 1
            if(arr[i] == 0) prefixSum+=-1;
            else prefixSum+=1;
            //if sum is seen then equal one's and zero's(if sum is repeating means equal number of -1 and 1)
            if(map.containsKey(prefixSum)){
                length = Math.max(length, i - map.get(prefixSum));
            }else{
                map.put(prefixSum, i);
            }
        }
        
        return length;
    }
}
