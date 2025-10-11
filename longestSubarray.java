class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n<3) return n;
        int curCount = 2;
        int maxCount = 2;
        
        for(int i =0;i<n-2;i++){
            int a = nums[i] + nums[i+1];            
            
             
            if(a == nums[i+2]){
                curCount += 1;
            }else{
                curCount = 2;
                
            }
                maxCount = Math.max(maxCount,curCount);
        }
        return maxCount;
        
        
    }
}©leetcode
