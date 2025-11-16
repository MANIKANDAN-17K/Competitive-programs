class Solution {
    public int numSub(String s) {
        int n = s.length();
        long cnt = 0;
        long res = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                res += (cnt*(cnt+1))/2;
                cnt = 0;
                
            }else{
                cnt++;
            }
        }
        res %= 1_000_000_007;
        return (cnt == 0) ? (int) res : (int)(res += (cnt*(cnt+1))/2);
    }
}
