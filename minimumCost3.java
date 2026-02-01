class Solution {
    public int minimumCost(int[] nums) {
        int a = nums[0];
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        for(int i = 1;i<nums.length;i++){
            
            if(b > nums[i]){
                c = b;
                b = nums[i];
            }else if(c > nums[i]){
                c = nums[i];
            }
        }
        return a+b+c;
    }
}
