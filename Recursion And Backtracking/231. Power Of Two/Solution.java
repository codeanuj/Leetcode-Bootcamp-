class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if(n == 1) return true;

        return (n%2==0) && isPowerOfTwo(n/2);
        
    }
  //O(1)
   public boolean isPowerOfTwo(int n) {
        return ((Math.log10(n)/Math.log10(2))%1) == 0;
    }
}
