class Solution {
    public double separateSquares(int[][] squares) {
        double lo = 0;
        double hi = 2*1e9;
        for(int i = 0;i<60;i++){
            double mid = (lo + hi)/2.0;
            double diff = helper(mid,squares);
            if(diff > 0){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        return hi;
    }
    private double helper(double line,int[][] square){
        double aAbove = 0,aBelow=0;
        for(int i = 0;i<square.length;i++){
            int x = square[i][0];
            int y = square[i][1];
            int l = square[i][2];

            double total = (double) l*l;
            if(line <= y){
                aAbove += total;
            }else if(line >= y+l){
                aBelow += total;
            }else{
                double aboveH = (y+l) - line;
                double belowH = line - y;
                aAbove += l * aboveH;
                aBelow += l * belowH;
            }
        }
        return aAbove - aBelow;
    }
}
