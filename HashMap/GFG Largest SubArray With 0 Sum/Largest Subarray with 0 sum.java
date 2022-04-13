class GfG
{
    int maxLen(int arr[], int n){
      
      HashMap<Integer, Integer> map = new HashMap();
      /*To counter the corner cases*/
      map.put(0, -1);
      int ans=0;
      int sum=0;
      for(int i=0; i<arr.length; i++){
          sum+=arr[i];
        /* If sum is seen before then the subarray is with 0 length*/
               if(map.containsKey(sum)){
                  ans = Math.max(ans, i- map.get(sum));
               }else{
                 map.put(sum, i);
               }           
       }
       return ans;
    }
}
