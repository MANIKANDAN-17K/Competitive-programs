class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxR = new int[n+1];
        int[] maxC = new int[n+1];
        int[] minR = new int[n+1];
        int[] minC = new int[n+1];

        Arrays.fill(minR,n+1);
        Arrays.fill(minC,n+1);

        for(int[] point : buildings){
            int x = point[0];
            int y = point[1];
            maxR[y] = Math.max(maxR[y],x);
            minR[y] = Math.min(minR[y],x);
            maxC[x] = Math.max(maxC[x],y);
            minC[x] = Math.min(minC[x],y); 
        }
        int res = 0;
        for(int[] point : buildings){
            int x = point[0];
            int y = point[1];
            if(x > minR[y] && x < maxR[y] && y > minC[x] && y < maxC[x]){
                res++;
            }
        }
        return res;
    }
}
