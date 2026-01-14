class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length,count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;++j){
                if(isPreSuf(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isPreSuf(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1> n2) return false;
        return s2.substring(0,n1).equals(s1) && s2.substring(n2 - n1).equals(s1);

    }
}
