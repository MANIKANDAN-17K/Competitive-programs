class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long ans =0;
        int[] pre = new int[n*2 + 1];
        pre[n] = 1;
        long preSum = 0;
        int count = n;
        for(int i = 0;i<n;++i){
            if(nums[i] == target){
                preSum += pre[count];
                ++count;
                ++pre[count];
            }else{
                --count;
                preSum-= pre[count];
                ++pre[count];
            }
            ans += preSum;
        }
        return ans;
    }
}
