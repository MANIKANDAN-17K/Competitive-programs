class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int mxh = 1;
        int mxv = 1;
        int cur = 1;
        for(int i = 1;i<hBars.length;i++){
            if(hBars[i] == hBars[i -1] + 1) cur++;
            else cur = 1;
            mxh = Math.max(mxh,cur);
        }
        cur = 1;
        for(int i = 1;i<vBars.length;i++){
            if(vBars[i] == vBars[i-1] +1) cur++;
            else cur = 1;
            mxv = Math.max(mxv,cur);
        }
        int side = Math.min(mxh + 1 , mxv + 1);
        return side * side;
    }
}
