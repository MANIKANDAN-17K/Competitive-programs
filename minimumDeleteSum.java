class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = n - 1;i>=0;i--){
            for(int j = m -1;j>= 0;j--){
                if(s2.charAt(j) == s1.charAt(i)){
                    dp[i][j] = s1.charAt(i) + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        int tot = 0;
        for(char c : s1.toCharArray()) tot += c;
        for(char c : s2.toCharArray()) tot += c;

        return tot - 2 * dp[0][0];
    }
}
