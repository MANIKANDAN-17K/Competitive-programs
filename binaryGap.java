class Solution {
    public int binaryGap(int n) {
        int dis = -1;
        int res = 0;
        for(int i = 0;i<32;i++){
            if(((n>>i)&1)>0){
                if(dis >= 0){
                    res = Math.max(res,i - dis);
                }
                dis = i;
            }
        }
        return res;
    }
}
