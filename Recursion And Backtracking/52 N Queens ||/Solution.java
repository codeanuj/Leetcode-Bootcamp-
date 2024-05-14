class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int[] result = {0};

        for(int i=0; i<n; i++)
           for(int j=0; j<n; j++)
               board[i][j]='.';

        totalNQueens(board, 0, n, result);
        return result[0];
    }

    private void totalNQueens(char[][] board, int currentRow, int n, int[] result){
        if(currentRow == n){
            result[0]+=1;
            return;
        }

        for(int currentCol = 0; currentCol<n; currentCol++){
            if(isValid(board, currentRow, currentCol, n)){
                board[currentRow][currentCol] = 'Q';
                totalNQueens(board, currentRow+1, n, result);
            }
            board[currentRow][currentCol] = '.';
        }
        return;
    }
    
    private boolean isValid(char[][] board, int currentRow, int currentCol, int n){
        return isRowValid(board, currentRow, n) && isColumnValid(board, currentCol, n) && isDiagonalValid(board, currentRow, currentCol, n);
    }

    private boolean isRowValid(char[][] board, int currentRow, int n){
        for(int currentCol = 0; currentCol<n; currentCol++){
            if(board[currentRow][currentCol] == 'Q') return false;
        }
        return true;
    }

    private boolean isColumnValid(char[][] board, int currentCol, int n){
        for(int currentRow = 0; currentRow<n; currentRow++){
            if(board[currentRow][currentCol] == 'Q') return false;
        }
        return true;
    }

    private boolean isDiagonalValid(char[][] board, int currentRow, int currentCol, int n){
        int x = currentRow;
        int y = currentCol;
        //left up diagonal
        while(x>=0 && y>=0){
            if(board[x][y] == 'Q') return false;
            x-=1;
            y-=1;
        }
        //right up diagonal
        x = currentRow;
        y = currentCol;
        while(x>=0 && y<n){
            if(board[x][y] == 'Q') return false;
            x-=1;
            y+=1;
        }

        return true;
    }
}
