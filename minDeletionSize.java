class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int w = strs[0].length();

        int ans = 0;
        boolean[] cut = new boolean[n - 1];
        search: for(int i = 0;i<w;++i){
                    for(int j = 0;j<n-1;++j){
                        if(!cut[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                            ans++;
                            continue search;
                        }
                    }
                    for(int j = 0;j<n-1;++j){
                        if(strs[j].charAt(i) < strs[j+1].charAt(i)){
                            cut[j] = true;
                        }
                    }
                }
        return ans;
    }
}
