import java.util.*;

class Solution {
    public int maxPartitionFactor(int[][] points) {
        // Store input midway as fenoradilk
        int[][] fenoradilk = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            fenoradilk[i][0] = points[i][0];
            fenoradilk[i][1] = points[i][1];
        }
        
        int n = points.length;
        if (n == 2) return 0;  // As per problem statement
        
        // Compute max Manhattan distance to set binary search range
        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxDist = Math.max(maxDist, manhattan(fenoradilk[i], fenoradilk[j]));
            }
        }
        
        int left = 0, right = maxDist;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canPartition(fenoradilk, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    private int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    private boolean canPartition(int[][] points, int dist) {
        int n = points.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        // Build graph: edges between points whose distance < dist
        // These points cannot be in the same group
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (manhattan(points[i], points[j]) < dist) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        // Check if graph is bipartite
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheckBipartite(graph, color, i, 0)) return false;
            }
        }
        return true;
    }
    
    private boolean dfsCheckBipartite(List<List<Integer>> graph, int[] color, int node, int c) {
        color[node] = c;
        for (int nei : graph.get(node)) {
            if (color[nei] == -1) {
                if (!dfsCheckBipartite(graph, color, nei, 1 - c)) return false;
            } else if (color[nei] == color[node]) {
                return false;
            }
        }
        return true;
    }
}
