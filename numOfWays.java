class Solution {
    public int numOfWays(int n) {
        long A = 6;
        long B = 6;
        long mod = 1_000_000_007;
        for(int i = 2;i<=n;i++){
            long newA = (2 * A + 2*B) % mod;
            long newB = (2 * A + 3*B) % mod;
            A = newA;
            B = newB;
        }
        return (int) ((A+B)%mod);
    }
}
