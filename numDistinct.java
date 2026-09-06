class Solution {
    public int numDistinct(String s, String t) {
        int n = t.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(char ch : s.toCharArray()){
            for(int i = n;i>= 1;i--){
                if(ch == t.charAt(i - 1)){
                    dp[i] += dp[i-1];
                }
            }
        }
        return dp[n];
    }
}
