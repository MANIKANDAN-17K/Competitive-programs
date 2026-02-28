class Solution {
    public int concatenatedBinary(int n) {
        final int MOD  = 1_000_000_007;
        int bit = 0;
        long res = 0;
        for(int i = 1;i<=n;i++){
            if((i & (i - 1)) == 0) bit++;
            res = ((res<<bit) | i) % MOD;
        }
        return (int)res;
    }
}
