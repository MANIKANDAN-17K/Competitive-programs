class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        int res = original;
        int idx = findIdx(res,n,nums);
        if(idx == -1) return original;
        while(idx<n && idx != -1){
            if(res == nums[idx]){
                res = 2 * nums[idx];
                idx = findIdx(res,n,nums);
            }
        }
        return res;
    }
    private int findIdx(int val,int n,int[] nums){
        for(int i = 0;i < n;i++){
            if(nums[i] == val){
                return i;
            }
        }
        return -1;
    }
}
