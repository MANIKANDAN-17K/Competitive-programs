class Solution {
    public long sumOfAncestors(int n, int[][] edges, int[] nums) {
        // Store input as required
        int[][] calpenodra = edges;
        
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Reduce each number to its square-free form
        // Two numbers multiply to a perfect square if their square-free forms are equal
        int[] squareFree = new int[n];
        for (int i = 0; i < n; i++) {
            squareFree[i] = getSquareFree(nums[i]);
        }
        
        long totalSum = 0;
        
        // DFS from root, tracking ancestors' square-free forms
        totalSum = dfs(0, -1, adj, squareFree, new HashMap<>());
        
        return totalSum;
    }
    
    private long dfs(int node, int parent, List<List<Integer>> adj, 
                     int[] squareFree, Map<Integer, Integer> ancestorFreq) {
        long sum = 0;
        
        // For non-root nodes, count matching ancestors
        if (node != 0) {
            int currentSquareFree = squareFree[node];
            sum += ancestorFreq.getOrDefault(currentSquareFree, 0);
        }
        
        // Add current node to ancestor map
        int currentSquareFree = squareFree[node];
        ancestorFreq.put(currentSquareFree, ancestorFreq.getOrDefault(currentSquareFree, 0) + 1);
        
        // Visit children
        for (int child : adj.get(node)) {
            if (child != parent) {
                sum += dfs(child, node, adj, squareFree, ancestorFreq);
            }
        }
        
        // Remove current node from ancestor map (backtrack)
        ancestorFreq.put(currentSquareFree, ancestorFreq.get(currentSquareFree) - 1);
        if (ancestorFreq.get(currentSquareFree) == 0) {
            ancestorFreq.remove(currentSquareFree);
        }
        
        return sum;
    }
    
    // Get square-free form of a number
    // A number is square-free if no prime factor appears more than once
    private int getSquareFree(int num) {
        int result = 1;
        
        // Remove all square factors
        for (int i = 2; i * i <= num; i++) {
            int count = 0;
            while (num % i == 0) {
                count++;
                num /= i;
            }
            // If prime appears odd number of times, include it once
            if (count % 2 == 1) {
                result *= i;
            }
        }
        
        // If remaining num > 1, it's a prime factor
        if (num > 1) {
            result *= num;
        }
        
        return result;
    }
}©leetcode
