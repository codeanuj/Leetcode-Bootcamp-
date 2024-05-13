class Solution {
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> result = new ArrayList<>();
        findUniquePath(m, 0, 0, n, "", result);
        return result;
    }
    
    private static void findUniquePath(int[][] grid, int currentRow, int currentColumn, int n, String currentPath, ArrayList<String> answer){
        if(currentRow >= n || currentRow < 0 || currentColumn >= n || currentColumn < 0 || grid[currentRow][currentColumn]<=0) return;
        
        if(currentRow == n-1 && currentColumn == n-1){
            answer.add(currentPath);
            return;
        }
        
        grid[currentRow][currentColumn] = -1;
        
       
        findUniquePath(grid, currentRow+1, currentColumn, n, currentPath+"D", answer);
        

        findUniquePath(grid, currentRow, currentColumn-1, n, currentPath+"L", answer);


        findUniquePath(grid, currentRow, currentColumn+1, n, currentPath+"R", answer);
        

        findUniquePath(grid, currentRow-1, currentColumn, n, currentPath+"U", answer);
        
        grid[currentRow][currentColumn] = 1;
        return;
        
    }
}
