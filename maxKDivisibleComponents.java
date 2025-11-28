class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        for(int i = 0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }
        int[] componentCount = new int[1];
        dfs(0,-1,adjList,values,k,componentCount);
        return componentCount[0];
    }
    private int dfs(int curNode, int parNode,List<Integer>[] adjList,int[] nodeValue,int k,int[] compCount){
        int sum = 0;
        for(int neig : adjList[curNode]){
            if(neig != parNode){
                sum += dfs(
                    neig,
                    curNode,
                    adjList,
                    nodeValue,
                    k,
                    compCount
                );
                sum %= k;
            }
        }
        sum += nodeValue[curNode];
        sum %= k;
        if(sum == 0){
            compCount[0]++;
        }
        return sum;
    }
}
