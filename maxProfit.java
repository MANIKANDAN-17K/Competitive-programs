class Solution {
    static final int N = 161;
    static final int N4 = N * 4;
    int[][] profit = new int[N][2];
    List<Integer>[] children = new ArrayList[N];
    int[][][][] dp = new int[N][2][2][N];
    boolean[] vis = new boolean[N4];
    int n;

    private void buildTree(int[][] hierarchy){
        for(int i = 0;i<n;i++){
            children[i] = new ArrayList<>();
        }
        for(int[] e : hierarchy){
            int u = e[0] - 1;
            int v = e[1] - 1;
            children[u].add(v);
        }
    }
    void dfs(int node,int bossBuy,int buy,int budget,int[] present){
        int state = (node << 2) | (bossBuy << 1) | buy;
        if(vis[state]) return;
        vis[state] = true;

        int[] cache = dp[node][bossBuy][buy];
        Arrays.fill(cache,0,budget + 1,Integer.MIN_VALUE);
        int cost = 0;
        if(buy == 1){
            cost = bossBuy == 1 ? present[node] / 2 : present[node];
        }
        if(cost <= budget){
            cache[cost] = (buy == 1) ? profit[node][bossBuy] : 0;
        }
        int[] cur = new int[budget + 1];
        int[] merged = new int[budget + 1];
        System.arraycopy(cache, 0, cur, 0,budget + 1);
        for(int child : children[node]){
            dfs(child,buy, 1,budget,present);
            dfs(child,0,0,budget,present);
            int[] take = dp[child][buy][1];
            int[] skip = dp[child][0][0];
            Arrays.fill(merged,0,budget+1,Integer.MIN_VALUE);
            for(int b = 0;b<= budget;b++){
                if(cur[b] == Integer.MIN_VALUE) continue;
                for(int x = 0; b+x <= budget;x++){
                    int best = Math.max(take[x],skip[x]);
                    if(best != Integer.MIN_VALUE){
                        merged[ b+x] = Math.max(merged[ b+x],cur[b] + best);
                    }
                }
            }
            System.arraycopy(merged, 0,cur,0,budget+1);
        }
        System.arraycopy(cur,0,cache,0,budget+1);
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        Arrays.fill(vis,false);
        for(int i = 0;i<n;i++){
            profit[i][0] = future[i] - present[i];
            profit[i][1] = future[i] - present[i] / 2;
        }
        buildTree(hierarchy);
        dfs(0,0,0,budget,present);
        dfs(0,0,1,budget,present);
        int ans = 0;
        for(int b = 0;b <= budget;b++){
            ans = Math.max(ans, dp[0][0][0][b]);
            ans = Math.max(ans, dp[0][0][1][b]);
        }
        return ans;
    }
}
