class Solution {
    public int countTrapezoids(int[][] points) {
       HashMap<Integer,Integer> pt = new HashMap<>();
        long ans = 0;
        long sum = 0;
        for(int[] p : points){
            pt.put(p[1],pt.getOrDefault(p[1],0)+1);
        }
        for(int val : pt.values()){
            long edge = ((long)val*(val - 1))/2;
            ans = (ans + edge * sum)%1000000007;
            sum = (edge + sum)%1000000007;
        }
        return (int) ans;
    }
}
