class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<size; i++){
            int key = n+arr[i];
            if(map.containsKey(key) || map.containsKey(arr[i]-n)) return true;
            map.put(arr[i], i);
        }
        return false;
    }
}
