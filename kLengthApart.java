class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int LastIndex = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                if(LastIndex != -1 && i - LastIndex - 1 < k){
                    return false;
                }
                LastIndex = i;
            }
        }
        return true;
    }
}
