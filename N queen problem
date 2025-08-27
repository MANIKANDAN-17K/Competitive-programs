class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row,'.');
        backtracking(sol,board,0,n);
        return sol;
    }
    private void backtracking(List<List<String>> sol,char[][] board, int row, int n){
        if(row == board.length){
            sol.add(construct(board));
            return;
        }
        for(int col = 0;col < n ;col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                backtracking(sol,board,row+1,n);
                board[row][col] = '.';
            }
        }
    }
    private boolean isSafe(char[][] board,int row,int col,int n){
        for(int i = 0;i<row;i++){
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row -1, j = col -1;i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row -1, j = col+1; i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(char[] row : board){
            res.add(new String(row));
        }
        return res;
    }
}
