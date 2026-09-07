class Solution {
    int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int tot = 0;
        int n = s.length();
        int[] dp = new int[26];
        for(int i = 0;i<n;i++){
            int c = s.charAt(i) - 97; 
            int add = ( tot - dp[c] + mod) % mod;
            dp[c] = 1 + tot;
            tot = (add + dp[c]) % mod;
        }
        return tot;
    }
}
