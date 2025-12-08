class Solution {
    public int countTriples(int n) {
        int res = 0;
        for(int i = 1;i<= n;++i){
            for(int j = 1;j<=n;++j){
                int c = (int) Math.sqrt(i*i+j*j+0.1);
                if(c <= n && c*c == i*i+j*j){
                    ++res;
                }
            }
        }
        return res;
    }
}
