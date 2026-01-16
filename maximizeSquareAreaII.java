class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];
        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;
        for(int i = 0;i<h.length-2;i++) h[i+1] = hFences[i];
        for(int i = 0;i<v.length-2;i++) v[i+ 1] = vFences[i];
        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<h.length;i++){
            for(int j = i+1;j<h.length;j++){
                set.add(h[j] - h[i]);
            }
        }
        long best = -1;
        for(int i = 0;i<v.length;i++){
            for(int j = i+1;j<v.length;j++){
                if(set.contains(v[j] - v[i])){
                    best = Math.max(best,v[j] - v[i]);
                }
            }
        }
        if(best == -1) return -1;
        return (int) ((best * best) % 1_000_000_007);
    }
}
