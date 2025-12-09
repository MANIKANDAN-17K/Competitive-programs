class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> numcnt = new HashMap<>();
        Map<Integer,Integer> numPartialCnt = new HashMap<>();
        for(int i : nums){
            numcnt.put(i,numcnt.getOrDefault(i,0)+1);
        }
        long ans = 0;
        for(int i : nums){
            int targ = i * 2;
            int lcnt = numPartialCnt.getOrDefault(targ,0);
            numPartialCnt.put(i,numPartialCnt.getOrDefault(i,0)+1);
            int rcnt = numcnt.getOrDefault(targ,0) - numPartialCnt.getOrDefault(targ,0);
            ans = (ans + (long) lcnt * rcnt) % 1000000007;
        }
        return (int)ans;
    }
}
