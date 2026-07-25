class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        res.add(nums[0]);
        int maxR = 0;
        int maxL = nums[0];
        if(n == 1) return res;
        for(int i = 1;i<n-1;i++){
            if(maxL < nums[i]){
                maxL = nums[i];
                res.add(nums[i]);
            }else{
                for(int j = n - 1;j>i;j--){
                    maxR = Math.max(maxR,nums[j]);
                }
                if(maxR < nums[i]){
                    res.add(nums[i]);
                }
                maxR = 0;
            }
        }
        res.add(nums[n-1]);
        return res;
    }
}
