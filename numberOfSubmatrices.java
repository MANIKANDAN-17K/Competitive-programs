class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[] sumX = new int[m];
        int[] sumY = new int[m];
        int res = 0;
        for(int i =0;i<n;i++){
            int rx = 0,ry = 0;
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 'X') rx++;
                else if(grid[i][j] == 'Y') ry++;
                sumX[j] += rx;
                sumY[j] += ry;
                if(sumY[j] > 0 && sumX[j] == sumY[j]) res++;
            }
        }
        return res;
    }
}
