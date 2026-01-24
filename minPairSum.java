class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0,l=0,r= nums.length-1;
        while(l<r){
            max = Math.max(max,nums[l++]+nums[r--]);
        }return max;
    }
}
