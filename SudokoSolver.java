class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
    private boolean backtracking(char[][] board){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char num = '1';num <= '9';num++){
                        if(isValid(board,i,j,num)){
                            board[i][j] = num;
                            if(backtracking(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,char num){
        for(int i = 0;i<9;i++){
            if(board[row][i] == num) return false;
        }
        for(int i = 0;i<9;i++){
            if(board[i][col] == num) return false;
        }

        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        for(int i = sr;i < sr+3;i++){
            for(int j = sc;j<sc+3;j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
}
