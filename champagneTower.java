class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] ans = new double[102][102];
        ans[0][0] = (double) poured;
        for(int r = 0; r <= query_row;++r){
            for(int c = 0;c <= r ; ++c){
                double q = (ans[r][c] - 1.0) / 2.0;
                if(q > 0){
                    ans[r+1][c] += q;
                    ans[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1,ans[query_row][query_glass]);
    }
}
