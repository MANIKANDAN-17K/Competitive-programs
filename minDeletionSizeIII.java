class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = n - 2;i>= 0;--i){
            search: for(int j = i+1;j<n;++j){
                for(String row : strs){
                    if(row.charAt(i) > row.charAt(j)){
                        continue search;
                    }
                }
                dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }
        int keep = 0;
        for(int x : dp){
            keep = Math.max(x,keep);
        }
        return n - keep;
    }
}
