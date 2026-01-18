class Solution {
    public int largestMagicSquare(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] rowSum = new int[R][C];
        for(int i = 0 ;i<R;i++){
            rowSum[i][0] = grid[i][0];
            for(int j = 1; j < C ; j++){
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }
        int[][] colSum = new int[R][C];
        for(int i = 0;i < C;i++){
            colSum[0][i] = grid[0][i];
            for(int j = 1;j < R;j++){
                colSum[j][i] = colSum[j-1][i] + grid[j][i];
            }
        }
        int maxSize = 1;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                int maxPoss = Math.min(R - i,C - j);
                for(int size = maxPoss; size > maxSize;size--){
                    if(isMagic(i,j,size,grid,rowSum,colSum)){
                        maxSize = size;
                        break;
                    }
                }
            }
        }
        return maxSize;
    }
    private boolean isMagic(
        int sr,int sc,int size,int[][]grid,int[][] rowSum,int[][] colSum
    )
    {
        int target = rowSum[sr][sc + size - 1] - (sc > 0 ? rowSum[sr][sc - 1] : 0);
        for(int r = sr ; r <sr+size;r++){
            int sum = rowSum[r][sc + size - 1] - (sc > 0 ? rowSum[r][sc - 1] : 0);
            if(sum != target) return false;
        }
        for(int c = sc; c < sc + size;c++){
            int sum = colSum[sr + size - 1][c] - (sr > 0 ? colSum[sr - 1][c] : 0);
            if(sum != target) return false;
        }
        int d1 = 0;
        for(int k = 0;k < size;k++){
            d1 += grid[sr+k][sc+k];
        }
        if(d1 != target) return false;

        int d2 = 0;
        for(int k = 0;k<size;k++){
            d2+= grid[sr + size - 1 - k][sc + k];
        }
        return d2 == target;
    }
}
