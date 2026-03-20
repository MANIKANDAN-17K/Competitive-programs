class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k+1];
        for(int i = 0;i + k <= m;i++){
            for(int j = 0; j + k <= n;j++){
                ArrayList<Integer> grd = new ArrayList<>();
                for(int x = i;x<i+k;x++){
                    for(int y = j;y<j+k;y++){
                        grd.add(grid[x][y]);
                    }
                }
                Collections.sort(grd);
                int Kmin = Integer.MAX_VALUE;

                for(int t = 1;t<grd.size();t++){
                    if(grd.get(t).equals(grd.get(t-1))){
                        continue;
                    }
                    Kmin = Math.min(Kmin,grd.get(t) - grd.get(t - 1));
                }
                if(Kmin != Integer.MAX_VALUE)
                    res[i][j] = Kmin;
            }
        }
        return res;
    }
}
