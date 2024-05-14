class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++)
           for(int j=0; j<n; j++)
               board[i][j]='.';
        
        solveQueens(board, 0, n, answer);
        return answer;
    }

    private void solveQueens(char[][] board, int currentRow, int n, List<List<String>> answer){
        if(currentRow == n){
            answer.add(constructList(board, n));
            return;
        }

        for(int currentCol = 0; currentCol<n; currentCol++){
            if(isValid(board, currentRow, currentCol, n)){
                board[currentRow][currentCol] = 'Q';
                solveQueens(board, currentRow+1, n, answer);
            }
            board[currentRow][currentCol] = '.';
        }
        return;
    }

    private List<String> constructList(char[][] board, int n){
        List<String> currentList = new ArrayList<>();
        for(int i=0; i<n; i++){
            String current="";
            for(int j=0; j<n; j++)
                current+= board[i][j];
            currentList.add(current);
        }
        return currentList;
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
