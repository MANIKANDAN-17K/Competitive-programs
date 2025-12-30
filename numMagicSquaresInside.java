class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int r = 0; r + 2 < m;r++){
            for(int c = 0; c+2 < n;c++){
                if(isMagicSquare(grid,r,c)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid,int r,int c){
        String seq = "2943816729438167";
        String seqR = "7618349276183492";

        StringBuilder bdr = new StringBuilder();
        int[] bdrI = new int[]{0,1,2,5,8,7,6,3};
        for(int i: bdrI){
            int n = grid[r+i/3][c+(i%3)];
            bdr.append(n);
        }
        String bdrC = bdr.toString();
        return(
            grid[r][c] % 2 == 0 &&
            (seq.contains(bdrC) ||
            seqR.contains(bdrC)) &&
            grid[r+1][c+1] == 5
        );
    }
}
