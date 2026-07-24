class Solution {
    public int[] countOppositeParity(int[] nums) {
        if(nums.length == 1) return new int[]{0};
        int n = nums.length;
        int[] ans = new int[n];
        int odd = 0;
        int even = 0;
        for(int i = n - 1 ;i >= 0;i--){
           if(nums[i] % 2 == 0){
               ans[i] = odd;
               even++;
           }else{
               ans[i] = even;
               odd++;
           }
        }
        return ans;
    }
}©leetcode
