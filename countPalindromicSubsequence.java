class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int res = 0;
        int[] fst = new int[26];
        int[] lst = new int[26];
        for(int i = 0;i<26;i++){
            fst[i] = -1;
            lst[i] = -1;
        }
        for(int i = 0;i<n;i++){
            int c = s.charAt(i) - 'a';
            if(fst[c] == -1) fst[c] = i;
            lst[c] = i;
        }
        for(int c = 0;c<26;c++){
            if(fst[c] != -1 && lst[c] - fst[c] > 1){
                int mask = 0;
                for(int i = fst[c]+1; i < lst[c];i++){
                    mask |= 1 << (s.charAt(i) - 'a');
                }
                res += Integer.bitCount(mask);
            }
        }
        return res;
    }
}
