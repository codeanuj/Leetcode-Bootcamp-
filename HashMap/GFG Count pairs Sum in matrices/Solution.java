
class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        
       int row_one=0;
       int col_one=0;
       int row_two=n-1;
       int col_two=n-1;
       int count=0;
       while(row_one<n && row_two>=0){
           int key = mat1[row_one][col_one]+mat2[row_two][col_two];
           
           if(key==x){
               count++;
               col_one++;
               col_two--;
           }else if(key>x) col_two--;
           else col_one++;
           
           if(col_one>=n){
               col_one=0;
               row_one++;
           }
           if(col_two<0){
               col_two=n-1;
               row_two--;
           }
       }
       
       return count;
    }
}
