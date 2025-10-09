class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n - 2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(0,n-1,nums);
            return;   
        }

        for(int i = n - 1;i>=0;i--){
            if(nums[i] > nums[idx]){
                swap(i,idx,nums);
                break;
            }
        }
        reverse(idx+1,n-1,nums);
    }
    private void reverse(int start , int end,int[] nums){
        while(start < end){
            swap(start++,end--,nums);
        }
    }
    private void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
