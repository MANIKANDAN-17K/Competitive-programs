class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int res = 0;
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            for(int i = l;i<=r;i += k){
                nums[i] = (int)(((long)nums[i] * v) % 1_000_000_007);
            }
        }
        for(int x : nums){
            res ^= x;
        }
        return res;
    }   
}
