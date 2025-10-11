class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        for (int i = 0;i<n-1;i++){
            if(checker(s.substring(0,i+1)) == checker(s.substring(i+1,n))){
                return true;
            }
        }

        return false;
    }
    private int checker(String str){
        int res = 0;
        int n = str.length();
        for(int i =0;i<n;i++){
            res += str.charAt(i) + 1 - 'a';
        }
        return res;
    }
}©leetcode
