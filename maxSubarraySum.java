class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0;
        long maxSum = Long.MIN_VALUE;
        long[] Ksum = new long[k];
        for(int i = 0;i<k;i++){
            Ksum[i] = Long.MAX_VALUE / 2;
        }
        Ksum[k - 1] = 0;
        for(int i =0;i<n;i++){
            prefix += nums[i];
            maxSum = Math.max(maxSum, prefix - Ksum [ i % k]);
            Ksum[i % k] = Math.min(Ksum[i%k],prefix);
        }
        return maxSum;
    }
}
