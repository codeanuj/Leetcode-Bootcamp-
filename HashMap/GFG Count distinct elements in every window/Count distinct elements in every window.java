class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int distinct = 0;
        int release = 0;
        
        for(int i=0; i<k; i++){
            
            int currentVal = A[i];
            
            if(map.containsKey(currentVal)){
                map.put(currentVal, map.get(currentVal) + 1);
            }else{
                map.put(currentVal, 1);
                distinct +=1;
            }
        }
        list.add(distinct);
      
        for(int acquire=k; acquire<n; acquire++){
           //window size already k
          //first discard the element
                int discardElement = A[release];
                map.put(discardElement, map.get(discardElement)-1);
                
                if(map.get(discardElement)==0){
                    map.remove(discardElement);
                    distinct -= 1;
                }
            release+=1;
          
          //now size is k-1 so acquire one element
            int currentVal = A[acquire];
            if(map.containsKey(currentVal)){
                map.put(currentVal, map.get(currentVal)+1);
            }else{
                distinct +=1;
                map.put(currentVal, 1);
            }
            
            list.add(distinct);
        }
        
        return list;
    }
}
