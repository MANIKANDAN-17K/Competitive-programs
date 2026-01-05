class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long tot = 0;
        int minAbsval = Integer.MAX_VALUE;
        int neg = 0;
        for(int[] i : matrix){
            for(int val : i){
                tot += Math.abs(val);
                if(val < 0) neg++;
                minAbsval = Math.min(minAbsval,Math.abs(val));
            }
        }
        if(neg % 2 != 0){
            tot -= 2*minAbsval;
        }
        return tot;
    }
}
