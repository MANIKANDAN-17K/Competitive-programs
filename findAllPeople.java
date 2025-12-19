class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings,(a,b)-> a[2] - b[2]);
        Map<Integer,List<int[]>> sameTimeMeeting = new TreeMap<>();
        for(int[] meeting : meetings){
            int x = meeting[0],y = meeting[1],t = meeting[2];
            sameTimeMeeting.computeIfAbsent(t,k -> new ArrayList<>()).add(new int[]{x,y});
        }  
        UnionFind graph = new UnionFind(n);
        graph.unite(firstPerson,0);
        for(int t : sameTimeMeeting.keySet()){
            for(int[] meeting: sameTimeMeeting.get(t)){
                int x = meeting[0],y = meeting[1];
                graph.unite(x,y);
            }
            for(int[] meeting:sameTimeMeeting.get(t)){
                int x = meeting[0], y = meeting[1];
                if(!graph.connected(x,0)){
                    graph.reset(x);
                    graph.reset(y);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;++i){
            if(graph.connected(i,0)){
                ans.add(i);
            }
        }
        return ans;
    }
}
class UnionFind{
    private int[] parent;
    private int[] rank;
    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;++i){
            parent[i] = i;
        }
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void unite(int x,int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
        if(rank[px] > rank[py]){
            parent[py] = px;
        }else if(rank[px] < rank[py]){
            parent[px] = py;
        }else{
            parent[py] = px;
            rank[px] += 1;
        }
    }
    }
    public boolean connected(int x,int y){
        return find(x) == find(y);
    }
    public void reset(int x){
        parent[x] = x;
        rank[x] = 0;
    }
}
