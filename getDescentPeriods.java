class Solution {
    public long getDescentPeriods(int[] prices) {   
        int n = prices.length;
        long res = 1;
        int pre = 1;
        for(int i = 1;i<n;++i){
            if(prices[i] == prices[i-1] - 1){
                ++pre;
            }else{
                pre = 1;
            }
            res += pre;
        }
        return res;
    }
}
