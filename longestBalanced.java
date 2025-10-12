class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        for (int j = 0;j<n;j++){
            int[] freq = new int[26];
            for (int i = j;i<n;i++){
                freq[s.charAt(i) - 'a']++;
                
                if(isbalance(freq)){
                    res = Math.max(res,i - j+1);
                }
            }
            
        }
        
        return res;
    }
    private boolean isbalance(int[] freq){
        int comm = 0;
        for(int f : freq){
            if(f > 0){
                if(comm == 0){
                    comm = f;
                }else if(comm != f){
                    return false;
                }
            }
        }
        return comm != 0;
    }
}©leetcode
