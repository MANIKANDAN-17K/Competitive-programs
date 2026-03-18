class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] col = new int[m];
        int res = 0;
        for(int i =0;i<n;i++){
            int row = 0;
            for(int j = 0;j<m;j++){
                col[j] += grid[i][j];
                row += col[j];
                if(row <= k){
                    res++;
                }
            }
        }
        return res;
    }
}
