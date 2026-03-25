class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] rowSum = new long[n];
        long[] colSum = new long[m];
        long tot = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                tot += grid[i][j]; 
            }
        }
        if(tot % 2 != 0) return false;
        if(check(rowSum,tot)) return true;
        if(check(colSum,tot)) return true;
        return false;
    }
    private boolean check(long[] arr,long tot){
        long l = arr[0];
        long r = tot - l ;
        for(int i = 1;i<arr.length;i++){
            if(l == r) return true;
            else if ( l > r) return false;
            l += arr[i];
            r -= arr[i];
        }
        return false;
    }
}
